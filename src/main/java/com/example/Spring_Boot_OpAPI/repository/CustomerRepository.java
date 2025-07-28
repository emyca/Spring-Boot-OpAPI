package com.example.Spring_Boot_OpAPI.repository;

import com.example.Spring_Boot_OpAPI.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
