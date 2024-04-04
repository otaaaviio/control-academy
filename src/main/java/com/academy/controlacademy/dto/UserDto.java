package com.academy.controlacademy.dto;

import com.academy.controlacademy.entity.TrainingUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;
import org.hibernate.validator.constraints.Length;

public record UserDto(
    @NotBlank String name,
    @NotNull @Length(min = 14) String cpf,
    @NotNull Date birth_date,
    Boolean is_instructor,
    Set<TrainingUser> trainingUsers) {}
