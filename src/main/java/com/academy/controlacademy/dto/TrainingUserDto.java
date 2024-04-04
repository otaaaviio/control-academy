package com.academy.controlacademy.dto;

import com.academy.controlacademy.entity.Training;
import com.academy.controlacademy.entity.User;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record TrainingUserDto(@NotNull User user, @NotNull Training training, @NotNull Date date) {}
