/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.8).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-08T13:59:51.930Z")

@Api(value = "user", description = "the user API")
public interface UserApi {

    @ApiOperation(value = "Create user", nickname = "createUser", notes = "To create a new user if we end up needing one", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation")})
    @RequestMapping(value = "/user",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> createUser(@ApiParam(value = "Created user object", required = true) @Valid @RequestBody User body,
                                    @ApiParam(value = "Authorization code from email",
                                            required = true) @RequestHeader String username,
                                    @ApiParam(value = "Authorization code from email",
                                            required = true) @RequestHeader String minAuth);


    @ApiOperation(value = "Creates list of users with given input array", nickname = "createUsersWithArrayInput", notes = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation")})
    @RequestMapping(value = "/user/createWithArray",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> createUsersWithArrayInput(@ApiParam(value = "List of user object", required = true) @Valid @RequestBody List<User> body,
                                                   @ApiParam(value = "Authorization code from email",
                                                           required = true) @RequestHeader String username,
                                                   @ApiParam(value = "Authorization code from email",
                                                           required = true) @RequestHeader String minAuth);


    @ApiOperation(value = "Creates list of users with given input file", nickname = "createUsersWithListInput", notes = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation")})
    @RequestMapping(value = "/user/createFromFile",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> createUsersWithListInput(@ApiParam(value = "Authorization code from email",
            required = true) @RequestHeader String username,
                                                  @ApiParam(value = "Authorization code from email",
                                                          required = true) @RequestHeader String minAuth);

}
