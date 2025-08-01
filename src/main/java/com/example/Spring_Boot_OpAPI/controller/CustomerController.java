package com.example.Spring_Boot_OpAPI.controller;

import com.example.Spring_Boot_OpAPI.dto.CustomerDtoRequest;
import com.example.Spring_Boot_OpAPI.dto.CustomerDtoResponse;
import com.example.Spring_Boot_OpAPI.service.CustomerService;
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

    @PostMapping
    public ResponseEntity<CustomerDtoResponse> create(
            @RequestBody CustomerDtoRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.create(request));
    }

    @Tag(name = "GETs", description = "getting customer(s) data")
    @GetMapping
    public ResponseEntity<CustomerDtoResponse> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getAll());
    }

    @Tag(name = "GETs", description = "getting customer(s) data")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDtoResponse> getById(
            @PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDtoResponse> updateById(
            @PathVariable("id") Long id,
            @RequestBody CustomerDtoRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.updateById(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerDtoResponse> deleteById(
            @PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.deleteById(id));
    }
}
