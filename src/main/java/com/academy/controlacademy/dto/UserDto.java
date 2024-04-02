package com.academy.controlacademy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public record UserDto(
        @NotBlank String name, @NotNull @Length(min = 14) String cpf, @NotNull Date birth_date, Boolean is_instructor) {}
