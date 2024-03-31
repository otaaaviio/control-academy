package com.academy.controlacademy.dto;

import com.academy.controlacademy.entity.User;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record AttendanceHistoryDto(@NotNull User user, @NotNull Date date) {}
