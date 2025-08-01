package com.example.Spring_Boot_OpAPI.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class Customer {

    @Schema(
            name = "Id",
            example = "1",
            requiredMode = Schema.RequiredMode.AUTO,
            description = "Customer object id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Schema(
            name = "First name",
            example = "John",
            requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Customer first name")
    @NotNull
    @Size(min = 2, max = 24)
    @Column(name = "first_name")
    private String firstName;

    @Schema(
            name = "Last name",
            example = "Doe",
            requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Customer last name")
    @NotNull
    @Size(min = 2, max = 48)
    @Column(name = "last_name")
    private String lastName;

    @Schema(
            name = "Email",
            example = "john@mail.com",
            requiredMode = Schema.RequiredMode.REQUIRED,
            description = "Customer email")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;
}
