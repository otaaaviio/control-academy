package com.academy.controlacademy.dto;

import jakarta.validation.constraints.NotBlank;

public record PlanTypeDto(@NotBlank String name) {}
