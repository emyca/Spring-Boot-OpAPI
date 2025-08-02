package com.example.Spring_Boot_OpAPI.controller;

import com.example.Spring_Boot_OpAPI.dto.CustomerDtoRequest;
import com.example.Spring_Boot_OpAPI.dto.CustomerDtoResponse;
import com.example.Spring_Boot_OpAPI.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @Tag(name = "Create")
    @Operation(
            summary = "Creates new customer",
            description = "Creates new Customer object or fails.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "New Customer data to be saved.",
                    required = true,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerDtoRequest.class),
                            examples = @ExampleObject(
                                    name = "Customer data to save",
                                    description = "New Customer data for saving into DB.",
                                    value = """
                                            {
                                            	"firstName": "John",
                                            	"lastName": "Doe",
                                            	"email": "john@mail.com"
                                            }"""))))
    @ApiResponses({
            @ApiResponse(responseCode = "201",
                    description = "Customer creation success",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerDtoResponse.class),
                            examples = @ExampleObject(
                                    name = "Successful Customer creation",
                                    description = "Customer has been created successfully.",
                                    value = """
                                            {
                                                "status": 201,
                                                "reasonPhrase": "Created",
                                                "success": true,
                                                "message": "Customer has been created successfully.",
                                                "customer": {
                                                    "id": 1,
                                                    "firstName": "John",
                                                    "lastName": "Doe",
                                                    "email": "john@mail.com"
                                                }
                                            }"""))}),
            @ApiResponse(responseCode = "204",
                    description = "Customer creation failure",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerDtoResponse.class),
                            examples = @ExampleObject(
                                    name = "Customer has NOT been created",
                                    description = "Unsuccessful Customer creation",
                                    value = """
                                            {
                                                "status": 204,
                                                "reasonPhrase": "No Content",
                                                "success": false,
                                                "message": "Customer has NOT been created."
                                            }""")))})
    @PostMapping
    public ResponseEntity<CustomerDtoResponse> create(
            @RequestBody CustomerDtoRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.create(request));
    }

    @Tag(name = "Read")
    @Operation(
            summary = "Gets all Customers or empty list")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Customer list is fetched and it's NOT empty.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerDtoResponse.class),
                            examples = @ExampleObject(
                                    name = "Customers exist",
                                    description = "Customer list occurs NOT empty.",
                                    value = """
                                            {
                                                "status": 200,
                                                "reasonPhrase": "OK",
                                                "success": true,
                                                "message": "Customer list have been fetched successfully.",
                                                "customerList": [
                                                    {
                                                        "id": 1,
                                                        "firstName": "Tom",
                                                        "lastName": "Orange",
                                                        "email": "tom@mail.com"
                                                    },
                                                    {
                                                        "id": 2,
                                                        "firstName": "Alice",
                                                        "lastName": "Terra",
                                                        "email": "alice@mail.com"
                                                    }
                                                ]
                                            }"""))}),
            @ApiResponse(responseCode = "404",
                    description = "Customer list is fetched and it's empty.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerDtoResponse.class),
                            examples = @ExampleObject(
                                    name = "No Customers",
                                    description = "Customer list occurs empty.",
                                    value = """
                                            {
                                                "status": 404,
                                                "reasonPhrase": "Not Found",
                                                "success": false,
                                                "message": "Customer list have NOT been found!",
                                                "customerList": []
                                            }""")))})
    @GetMapping
    public ResponseEntity<CustomerDtoResponse> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getAll());
    }

    @Tag(name = "Read")
    @Operation(
            summary = "Gets Customer by its id or fails")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Customer is got by its id.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerDtoResponse.class),
                            examples = @ExampleObject(
                                    name = "Customer exists",
                                    description = "Customer is got by its existing id.",
                                    value = """
                                            {
                                                "status": 200,
                                                "reasonPhrase": "OK",
                                                "success": true,
                                                "message": "Customer with id 1 has been fetched successfully.",
                                                "customer": {
                                                    "id": 1,
                                                    "firstName": "Alice",
                                                    "lastName": "Terra",
                                                    "email": "alice@mail.com"
                                                }
                                            }"""))}),
            @ApiResponse(responseCode = "404",
                    description = "Customer is NOT got by provided id.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerDtoResponse.class),
                            examples = @ExampleObject(
                                    name = "No Customer with such id",
                                    description = "Customer is NOT got by provided id. " +
                                            "The Customer was previously unsaved or deleted.",
                                    value = """
                                            {
                                                "status": 404,
                                                "reasonPhrase": "Not Found",
                                                "success": false,
                                                "message": "Customer with id 5 has NOT been found!"
                                            }""")))})
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDtoResponse> getById(
            @Parameter(
                    description = "Customer id to get the Customer by its id.",
                    required = true)
            @PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getById(id));
    }

    @Tag(name = "Update")
    @Operation(
            summary = "Updates customer by its id",
            description = "Updates specific Customer object. " +
                    "The response is Customer object updated by its id.")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDtoResponse> updateById(
            @PathVariable("id") Long id,
            @RequestBody CustomerDtoRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.updateById(id, request));
    }

    @Tag(name = "Delete")
    @Operation(
            summary = "Deletes customer by its id",
            description = "Deletes specific Customer object. " +
                    "The response is a message about Customer object " +
                    "deletion by its id.")
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDtoResponse> deleteById(
            @PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.deleteById(id));
    }
}
