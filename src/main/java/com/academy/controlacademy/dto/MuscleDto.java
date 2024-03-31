package com.academy.controlacademy.dto;

import jakarta.validation.constraints.NotBlank;

public record MuscleDto(@NotBlank String name) {}
