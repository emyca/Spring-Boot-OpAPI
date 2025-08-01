package com.example.Spring_Boot_OpAPI.dto;

import com.example.Spring_Boot_OpAPI.entity.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;

public record CustomerDtoResponse(
        @Schema(
                name = "Status",
                example = "200",
                requiredMode = Schema.RequiredMode.REQUIRED,
                description = "HTTP status code.")
        int status,
        @Schema(
                name = "Reason phrase",
                example = "OK",
                requiredMode = Schema.RequiredMode.REQUIRED,
                description = "HTTP status code reason phrase.")
        String reasonPhrase,
        @Schema(
                name = "Success",
                example = "true",
                requiredMode = Schema.RequiredMode.REQUIRED,
                description = "Indicates if work on the resource was successful.")
        boolean success,
        @Schema(
                name = "Message",
                example = "Customer has been created successfully.",
                requiredMode = Schema.RequiredMode.REQUIRED,
                description = "Custom response message.")
        String message,
         @Schema(
                name = "Customer object",
                requiredMode = Schema.RequiredMode.AUTO,
                description = "Customer object response body.")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        Customer customer,
        @Schema(
                name = "Customer object list",
                requiredMode = Schema.RequiredMode.AUTO,
                description = "Customer object list response body.")
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
