package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.configuration.Helper;
import io.swagger.model.Food;
import io.swagger.model.Order;
import io.swagger.model.response.BaseOrder;
import io.swagger.model.response.OrderDTO;
import io.swagger.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T13:59:51.930Z")

@Controller
public class OrderApiController implements OrderApi {

    @Autowired
    ResourceService service;

    @Autowired
    Helper helper;

    private static final Logger log = LoggerFactory.getLogger(OrderApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OrderApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteOrder(@ApiParam(value = "ID of the order that needs to be deleted",
            required = true) @PathVariable("orderId") UUID orderId,
                                            @ApiParam(value = "Authorization code from email",
                                                    required = true) @RequestHeader String username,
                                            @ApiParam(value = "Authorization code from email",
                                                    required = true) @RequestHeader String minAuth) {
        if (!helper.authenticateUser(username, minAuth))
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        String accept = request.getHeader("Accept");
        Order forId = new Order();
        forId.setId(orderId);
        service.deleteOrder(forId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> deleteOrderTragic(@ApiParam(value = "ID of the order that needs to be deleted",
            required = true) @PathVariable("orderId") UUID orderId,
                                                  @ApiParam(value = "Authorization code from email",
                                                          required = true) @RequestHeader String username,
                                                  @ApiParam(value = "Authorization code from email",
                                                          required = true) @RequestHeader String minAuth) {
        String accept = request.getHeader("Accept");
        //
        return deleteOrder(orderId, username, minAuth);
    }

    public ResponseEntity<Void> deleteOrderVictory(@ApiParam(value = "ID of the order that needs to be deleted",
            required = true) @PathVariable("orderId") UUID orderId,
                                                   @ApiParam(value = "Authorization code from email",
                                                           required = true) @RequestHeader String username,
                                                   @ApiParam(value = "Authorization code from email",
                                                           required = true) @RequestHeader String minAuth) {
        String accept = request.getHeader("Accept");
        Mailer.sendOrderReady("mark_davis@ultimatesoftware.com");
        return deleteOrder(orderId, username, minAuth);
    }

    public ResponseEntity<Order> getOrderById(@ApiParam(value = "ID of pet that needs to be fetched",
            required = true) @PathVariable("orderId") UUID orderId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Order>(new Order(), HttpStatus.BAD_REQUEST);
        }

        Order response = service.findOrderById(orderId);
        return new ResponseEntity<Order>(response, HttpStatus.OK);
    }

    public ResponseEntity<Order> placeOrder(@ApiParam(value = "order placed for purchasing the pet",
            required = true) @Valid @RequestBody OrderDTO body,
                                            @ApiParam(value = "Authorization code from email",
                                                    required = true) @RequestHeader String username,
                                            @ApiParam(value = "Authorization code from email",
                                                    required = true) @RequestHeader String minAuth) {
        if (!helper.authenticateUser(username, minAuth))
            return new ResponseEntity<Order>(HttpStatus.UNAUTHORIZED);
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
        }
        body.setPlacedBy(username);
        body.setId(UUID.randomUUID());
        BaseOrder base = body;
        Order order = new Order(base);
        ArrayList<Food> foods = new ArrayList<Food>();
        for (String s : body.getPayload()) {
            Food food = service.findFoodById(UUID.fromString(s));
            foods.add(food);
        }
        order.setPayload(foods);
        Order response = service.saveOrder(order);
        return new ResponseEntity<Order>(response, HttpStatus.CREATED);
    }


}
