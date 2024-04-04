package com.academy.controlacademy.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreditCardDto(
    @NotNull @Min(16) String number,
    @NotNull @Min(3) String cvv,
    @NotNull @Size(min = 7, max = 7) String expiration_date,
    @NotBlank String name) {}
