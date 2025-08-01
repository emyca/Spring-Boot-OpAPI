package com.example.Spring_Boot_OpAPI.controller;

import com.example.Spring_Boot_OpAPI.dto.CustomerDtoRequest;
import com.example.Spring_Boot_OpAPI.dto.CustomerDtoResponse;
import com.example.Spring_Boot_OpAPI.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
            summary = "Creates new customer",
            description = "Creates new Customer object. " +
                    "The response is newly created Customer object.")
    @PostMapping
    public ResponseEntity<CustomerDtoResponse> create(
            @RequestBody CustomerDtoRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.create(request));
    }

    @Tag(name = "GETs", description = "getting customer(s) data")
    @Operation(
            summary = "Gets all customers",
            description = "Gets all Customer objects. " +
                    "The response is all Customer objects array.")
    @GetMapping
    public ResponseEntity<CustomerDtoResponse> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getAll());
    }

    @Tag(name = "GETs", description = "getting customer(s) data")
    @Operation(
            summary = "Gets customer by its id",
            description = "Gets specific Customer object. " +
                    "The response is Customer object got by its id.")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDtoResponse> getById(
            @PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getById(id));
    }

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
