package com.academy.controlacademy.dto;

import com.academy.controlacademy.entity.Exercise;
import com.academy.controlacademy.entity.User;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record ExerciseWeightHistoryDto(
    @NotNull Exercise exercise,
    @NotNull Integer previous_weight,
    @NotNull Integer new_weight,
    @NotNull Date date,
    @NotNull User user) {}
