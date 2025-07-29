package com.example.Spring_Boot_OpAPI.service;

import com.example.Spring_Boot_OpAPI.dto.CustomerDtoRequest;
import com.example.Spring_Boot_OpAPI.dto.CustomerDtoResponse;
import com.example.Spring_Boot_OpAPI.dto.CustomerMapper;
import com.example.Spring_Boot_OpAPI.entity.Customer;
import com.example.Spring_Boot_OpAPI.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper mapper;
    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerMapper mapper, CustomerRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public CustomerDtoResponse create(CustomerDtoRequest request) {
        Customer customer = repository.save(mapper.dtoCreateToEntity(request));
        return (customer.getId() != null)
                ? new CustomerDtoResponse.Builder()
                    .status(HttpStatus.CREATED.value())
                    .reasonPhrase(HttpStatus.CREATED.getReasonPhrase())
                    .success(true)
                    .message(CustomerDtoResponse
                            .Message.SUCCESS_CREATE_MSG.getMessage())
                    .customer(customer)
                    .build()
                : new CustomerDtoResponse.Builder()
                    .status(HttpStatus.NO_CONTENT.value())
                    .reasonPhrase(HttpStatus.NO_CONTENT.getReasonPhrase())
                    .success(false)
                    .message(CustomerDtoResponse
                            .Message.FAILURE_CREATE_MSG.getMessage())
                    .build();
    }

    @Override
    public CustomerDtoResponse getAll() {
        return null;
    }

    @Override
    public CustomerDtoResponse getById(Long id) {
        return null;
    }

    @Override
    public CustomerDtoResponse updateById(Long id, CustomerDtoRequest request) {
        return null;
    }

    @Override
    public CustomerDtoResponse deleteById(Long id) {
        return null;
    }
}
