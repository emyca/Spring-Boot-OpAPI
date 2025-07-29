package com.example.Spring_Boot_OpAPI.dto;

import com.example.Spring_Boot_OpAPI.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer dtoCreateToEntity(CustomerDtoRequest request) {
        Customer customer = new Customer();
        customer.setId(request.id());
        customer.setFirstName(request.firstName());
        customer.setLastName(request.lastName());
        customer.setEmail(request.email());
        return customer;
    }

    public Customer dtoUpdateByIdToEntity(Long id,
                                          CustomerDtoRequest request,
                                          Customer customerToUpdate) {
        customerToUpdate.setId(id);
        customerToUpdate.setFirstName(request.firstName());
        customerToUpdate.setLastName(request.lastName());
        customerToUpdate.setEmail(request.email());
        return customerToUpdate;
    }
}
