package com.example.Spring_Boot_OpAPI.service;

import com.example.Spring_Boot_OpAPI.dto.CustomerDtoRequest;
import com.example.Spring_Boot_OpAPI.dto.CustomerDtoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

    @Override
    public ResponseEntity<CustomerDtoResponse> create(CustomerDtoRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<CustomerDtoResponse> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<CustomerDtoResponse> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<CustomerDtoResponse> updateById(Long id, CustomerDtoRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<CustomerDtoResponse> deleteById(Long id) {
        return null;
    }
}
