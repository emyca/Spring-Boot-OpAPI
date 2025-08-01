package com.example.Spring_Boot_OpAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerDtoRequest(
        @Schema(
                name = "Id",
                example = "1",
                requiredMode = Schema.RequiredMode.AUTO,
                description = "Customer object id")
        Long id,
        @Schema(
                name = "First name",
                example = "John",
                requiredMode = Schema.RequiredMode.REQUIRED,
                description = "Customer first name")
        String firstName,
        @Schema(
                name = "Last name",
                example = "Doe",
                requiredMode = Schema.RequiredMode.REQUIRED,
                description = "Customer last name")
        String lastName,
        @Schema(
                name = "Email",
                example = "john@mail.com",
                requiredMode = Schema.RequiredMode.REQUIRED,
                description = "Customer email")
        String email) {
}
