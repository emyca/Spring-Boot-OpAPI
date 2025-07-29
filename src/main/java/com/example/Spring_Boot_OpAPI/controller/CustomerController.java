package com.example.Spring_Boot_OpAPI.controller;

import com.example.Spring_Boot_OpAPI.dto.CustomerDtoRequest;
import com.example.Spring_Boot_OpAPI.dto.CustomerDtoResponse;
import com.example.Spring_Boot_OpAPI.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
