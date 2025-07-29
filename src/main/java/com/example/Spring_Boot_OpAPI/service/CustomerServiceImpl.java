package com.example.Spring_Boot_OpAPI.service;

import com.example.Spring_Boot_OpAPI.dto.CustomerDtoRequest;
import com.example.Spring_Boot_OpAPI.dto.CustomerDtoResponse;
import com.example.Spring_Boot_OpAPI.dto.CustomerMapper;
import com.example.Spring_Boot_OpAPI.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

    private CustomerMapper mapper;
    private CustomerRepository repository;

    public CustomerServiceImpl(CustomerMapper mapper, CustomerRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

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
