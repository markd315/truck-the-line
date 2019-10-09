package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.configuration.Helper;
import io.swagger.model.Food;
import io.swagger.model.Order;
import io.swagger.model.Vendor;
import io.swagger.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T13:59:51.930Z")

@Controller
public class PrintApiController implements PrintApi {

    @Autowired
    private ResourceService service;

    @Autowired
    private Helper helper;

    private static final Logger log = LoggerFactory.getLogger(PrintApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PrintApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Order>> print(@ApiParam(value = "Filter the printjob to only a certain vendor") @Valid
                                             @RequestParam(value = "vendor", required = false) String vendorId,
                                             @ApiParam(value = "Authorization code from email",
                                                     required = true) @RequestHeader String username,
                                             @ApiParam(value = "Authorization code from email",
                                                     required = true) @RequestHeader String minAuth) {
        if (!helper.adminOnly(minAuth))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        String accept = request.getHeader("Return");
        Collection<Order> list = service.findAllOrders();

        list = vendorFilter(list, vendorId);
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
        return htmlOrJson(accept, printingOrders);
    }

    public ResponseEntity<List<Order>> dryrun(@ApiParam(value = "Filter the printjob to only a certain vendor") @Valid
                                              @RequestParam(value = "vendor", required = false) String vendorId,
                                              @ApiParam(value = "Authorization code from email",
                                                      required = true) @RequestHeader String username,
                                              @ApiParam(value = "Authorization code from email",
                                                      required = true) @RequestHeader String minAuth) {
        if (!helper.adminOnly(minAuth))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        String accept = request.getHeader("Return");
        Collection<Order> list = service.findAllOrders();

        list = vendorFilter(list, vendorId);
        List<Order> printingOrders = new ArrayList<>();
        for (Order o : list) {
            if (o.getStatus().equals(Order.StatusEnum.SENDING_ORDER)) {
                printingOrders.add(o);
            }
        }
        printingOrders.sort(Comparator.comparing(Order::getDonationPriority));
        Collections.reverse(printingOrders);
        return htmlOrJson(accept, printingOrders);
    }

    public ResponseEntity<List<Order>> truckWaiting(@ApiParam(value = "Filter the printjob to only a certain vendor") @Valid
                                                    @RequestParam(value = "vendor", required = false) String vendorId,
                                                    @ApiParam(value = "Authorization code from email",
                                                            required = true) @RequestHeader String username,
                                                    @ApiParam(value = "Authorization code from email",
                                                            required = true) @RequestHeader String minAuth) {
        Collection<Order> list = service.findAllOrders();

        list = vendorFilter(list, vendorId);
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

    private ResponseEntity<List<Order>> htmlOrJson(String accept, List<Order> printingOrders) {
        if (accept != null && accept.equalsIgnoreCase("text/html")) {
            List<Food> foods = new ArrayList<>();
            for (Order o : printingOrders) {
                for (Food f : o.getPayload()) {
                    f.setOrderId(o.getId());
                }
                foods.addAll(o.getPayload());
            }
            Collections.sort(foods, new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    return o1.getVendor().compareTo(o2.getVendor());
                }
            });
            String html = "";
            UUID latestVendor = null;
            for (Food f : foods) {
                Vendor vendor = service.findVendorById(f.getVendor());
                if (!f.getVendor().equals(latestVendor)) {
                    latestVendor = f.getVendor();
                    html += "<h3>" + vendor.getName() + "</h3>";
                }
                html += "<p>" + f.getName() + " " + f.getOrderId() + "</p>";
            }
            Order o = new Order();
            o.setPlacedBy(html);
            return new ResponseEntity<List<Order>>(Collections.singletonList(o), HttpStatus.OK);
        }
        return new ResponseEntity<List<Order>>(printingOrders, HttpStatus.OK);
    }

    private Collection<Order> vendorFilter(Collection<Order> list, String vendorId) {
        if (vendorId == null || vendorId.equals("")) {
            return list;
        }
        List<Order> rm = new ArrayList<>();
        for (Order o : list) {
            boolean flag = false;
            for (Food f : o.getPayload()) {
                if (f.getVendor().toString().equals(vendorId)) {
                    flag = true;
                }
            }
            if (!flag) {
                rm.add(o);
            }
        }
        list.removeAll(rm);
        return list;
    }

}
