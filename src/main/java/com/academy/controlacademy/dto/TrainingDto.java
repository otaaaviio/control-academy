package com.academy.controlacademy.dto;

import com.academy.controlacademy.entity.Exercise;
import com.academy.controlacademy.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Set;

public record TrainingDto(
    @NotNull User user, @NotNull Date start_date, @NotNull Set<Exercise> exercises) {}
