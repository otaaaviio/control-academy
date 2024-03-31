package com.academy.controlacademy.dto;

import com.academy.controlacademy.entity.CreditCard;
import com.academy.controlacademy.entity.PlanType;
import com.academy.controlacademy.entity.User;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record PlanDto(
    @NotNull User user,
    @NotNull PlanType plan_type,
    @NotNull Double monthly_value,
    @NotNull Date start_date,
    @NotNull CreditCard credit_card) {}
