package com.example.Spring_Boot_OpAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CustomerDtoRequest(
        Long id,
        String firstName,
        String lastName,
        String email) {
}
