package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Food;
import io.swagger.model.Vendor;
import io.swagger.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T13:59:51.930Z")

@Controller
public class VendorApiController implements VendorApi {

    @Autowired
    ResourceService service;

    private static final Logger log = LoggerFactory.getLogger(VendorApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public VendorApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Vendor> createVendor(@ApiParam(value = "order placed for purchasing the pet",
            required = true) @Valid @RequestBody Vendor body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Vendor>(body, HttpStatus.BAD_REQUEST);
        }
        body.setId(UUID.randomUUID());
        for (Food food : body.getMenu()) {
            food.setId(UUID.randomUUID());
        }
        Vendor response = service.saveVendor(body);
        return new ResponseEntity<Vendor>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteVendor(@ApiParam(value = "ID of the order that needs to be deleted",
            required = true) @PathVariable("vendorId") UUID vendorId) {
        String accept = request.getHeader("Accept");
        Vendor forId = new Vendor();
        forId.setId(vendorId);
        service.deleteVendor(forId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Vendor> editVendor(@ApiParam(value = "ID of the order that needs to be changed",
            required = true) @PathVariable("vendorId") UUID vendorId, @Valid @RequestBody Vendor body) {
        String accept = request.getHeader("Accept");
        body.setId(vendorId);
        Vendor response = service.saveVendor(body);
        return new ResponseEntity<Vendor>(response, HttpStatus.OK);
    }

    public ResponseEntity<ArrayList<Vendor>> getAllInventory() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<ArrayList<Vendor>>(new ArrayList<Vendor>(), HttpStatus.BAD_REQUEST);
        }

        ArrayList<Vendor> response = (ArrayList<Vendor>) service.findAllVendors();
        return new ResponseEntity<ArrayList<Vendor>>(response, HttpStatus.OK);
    }

    public ResponseEntity<Vendor> getInventory(@ApiParam(value = "ID of pet that needs to be fetched",
            required = true) @PathVariable("vendorId") UUID vendorId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<Vendor>(new Vendor(), HttpStatus.BAD_REQUEST);
        }

        Vendor response = service.findVendorById(vendorId);
        return new ResponseEntity<Vendor>(response, HttpStatus.OK);
    }

}
