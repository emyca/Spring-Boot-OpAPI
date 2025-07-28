package com.example.Spring_Boot_OpAPI.dto;

import com.example.Spring_Boot_OpAPI.entity.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

public record CustomerDtoResponse(
        int status,
        String reasonPhrase,
        boolean success,
        String message,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Customer customer,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        List<Customer> customerList) {

    private CustomerDtoResponse(Builder builder) {
        this(
                builder.status,
                builder.reasonPhrase,
                builder.success,
                builder.message,
                builder.customer,
                builder.customerList
        );
    }

    public static class Builder {
        int status;
        String reasonPhrase;
        boolean success;
        String message;
        Customer customer;
        List<Customer> customerList;

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder reasonPhrase(String reasonPhrase) {
            this.reasonPhrase = reasonPhrase;
            return this;
        }

        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder customerList(List<Customer> customerList) {
            this.customerList = customerList;
            return this;
        }

        public CustomerDtoResponse build() {
            return new CustomerDtoResponse(this);
        }
    }

    @Getter
    public enum Message {

        SUCCESS_CREATE_MSG("Customer has been created successfully."),
        FAILURE_CREATE_MSG("Customer has NOT been created."),
        SUCCESS_GET_LIST_MSG("Customer list have been fetched successfully."),
        FAILURE_GET_LIST_MSG("Customer list have NOT been found!"),
        SUCCESS_GET_BY_ID_MSG("Customer with id %s has been fetched successfully."),
        FAILURE_GET_BY_ID_MSG("Customer with id %s has NOT been found!"),
        SUCCESS_UPDATE_BY_ID_MSG("Customer with id %s has been updated successfully."),
        SUCCESS_DELETE_BY_ID_MSG("Customer with id %s has been deleted successfully.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
