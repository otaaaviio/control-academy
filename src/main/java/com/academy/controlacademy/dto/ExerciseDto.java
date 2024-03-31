package com.academy.controlacademy.dto;

import com.academy.controlacademy.entity.Muscle;
import com.academy.controlacademy.entity.Training;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Set;

public record ExerciseDto(
    @NotBlank String name,
    @NotNull Integer num_series,
    @NotNull Integer min_reps,
    @NotNull Integer max_reps,
    @NotNull Integer weight,
    @NotNull Integer rest_time,
    @NotNull Set<Muscle> muscles) {}
