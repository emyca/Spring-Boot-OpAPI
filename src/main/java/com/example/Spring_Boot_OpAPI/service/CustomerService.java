package com.example.Spring_Boot_OpAPI.service;

import com.example.Spring_Boot_OpAPI.dto.CustomerDtoRequest;
import com.example.Spring_Boot_OpAPI.dto.CustomerDtoResponse;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    ResponseEntity<CustomerDtoResponse> create(CustomerDtoRequest request);
    ResponseEntity<CustomerDtoResponse> getAll();
    ResponseEntity<CustomerDtoResponse> getById(Long id);
    ResponseEntity<CustomerDtoResponse> updateById(Long id, CustomerDtoRequest request);
    ResponseEntity<CustomerDtoResponse> deleteById(Long id);
}
