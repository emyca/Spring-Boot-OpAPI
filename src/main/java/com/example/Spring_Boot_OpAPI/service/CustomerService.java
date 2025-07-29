package com.example.Spring_Boot_OpAPI.service;

import com.example.Spring_Boot_OpAPI.dto.CustomerDtoRequest;
import com.example.Spring_Boot_OpAPI.dto.CustomerDtoResponse;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    CustomerDtoResponse create(CustomerDtoRequest request);
    CustomerDtoResponse getAll();
    CustomerDtoResponse getById(Long id);
    CustomerDtoResponse updateById(Long id, CustomerDtoRequest request);
    CustomerDtoResponse deleteById(Long id);
}
