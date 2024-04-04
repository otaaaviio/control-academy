package com.academy.controlacademy.dto;

import com.academy.controlacademy.entity.Exercise;
import com.academy.controlacademy.entity.TrainingUser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record TrainingDto(
        @NotBlank String title, @NotNull Set<Exercise> exercises, Set<TrainingUser> trainingUsers) {}
