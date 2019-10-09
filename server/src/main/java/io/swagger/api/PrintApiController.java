package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Order;
import io.swagger.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T13:59:51.930Z")

@Controller
public class PrintApiController implements PrintApi {

    @Autowired
    private ResourceService service;
    private static final Logger log = LoggerFactory.getLogger(PrintApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PrintApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Order>> print(@ApiParam(value = "Filter the printjob to only a certain vendor") @Valid
                                             @RequestParam(value = "vendor", required = false) String vendorId) {
        String accept = request.getHeader("Accept");
        Collection<Order> list = service.findAllOrders();

        //TODO filter by vendor
        List<Order> printingOrders = new ArrayList<>();
        for (Order o : list) {
            if (o.getStatus().equals(Order.StatusEnum.SENDING_ORDER)) {
                o.setStatus(Order.StatusEnum.WAITING_FOR_TRUCK);
                service.saveOrder(o);
                printingOrders.add(o);
            }
        }
        printingOrders.sort(Comparator.comparing(Order::getDonationPriority));
        Collections.reverse(printingOrders);
        return new ResponseEntity<List<Order>>(printingOrders, HttpStatus.OK);
    }

    public ResponseEntity<List<Order>> dryrun(@ApiParam(value = "Filter the printjob to only a certain vendor") @Valid
                                              @RequestParam(value = "vendor", required = false) String vendorId) {
        String accept = request.getHeader("Accept");
        Collection<Order> list = service.findAllOrders();

        //TODO filter by vendor
        List<Order> printingOrders = new ArrayList<>();
        for (Order o : list) {
            if (o.getStatus().equals(Order.StatusEnum.SENDING_ORDER)) {
                printingOrders.add(o);
            }
        }
        printingOrders.sort(Comparator.comparing(Order::getDonationPriority));
        Collections.reverse(printingOrders);
        return new ResponseEntity<List<Order>>(printingOrders, HttpStatus.OK);
    }

    public ResponseEntity<List<Order>> truckWaiting(@ApiParam(value = "Filter the printjob to only a certain vendor") @Valid
                                                    @RequestParam(value = "vendor", required = false) String vendorId) {
        String accept = request.getHeader("Accept");
        Collection<Order> list = service.findAllOrders();

        //TODO filter by vendor
        List<Order> printingOrders = new ArrayList<>();
        for (Order o : list) {
            if (o.getStatus().equals(Order.StatusEnum.WAITING_FOR_TRUCK)) {
                printingOrders.add(o);
            }
        }
        printingOrders.sort(Comparator.comparing(Order::getDonationPriority));
        Collections.reverse(printingOrders);
        return new ResponseEntity<List<Order>>(printingOrders, HttpStatus.OK);
    }

}
