/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.8).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Order;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T13:59:51.930Z")

@Api(value = "print", description = "the print API")
public interface PrintApi {

    @ApiOperation(value = "Transitions from app to real-life.", nickname = "print", notes = "Moves all Waiting For Print orders to Waiting for Truck and returns a printable list of these, partitioned by vendor.", response = Order.class, authorizations = {
        @Authorization(value = "api_key")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Order.class),
        @ApiResponse(code = 400, message = "Invalid Order") })
    @RequestMapping(value = "/print",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Order> print(@ApiParam(value = "Filter the printjob to only a certain vendor") @Valid @RequestParam(value = "vendor", required = false) String vendor);

}