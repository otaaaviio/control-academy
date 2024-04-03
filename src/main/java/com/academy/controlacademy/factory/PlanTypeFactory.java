package com.academy.controlacademy.factory;

import com.academy.controlacademy.dto.PlanTypeDto;
import com.academy.controlacademy.entity.PlanType;
import com.academy.controlacademy.repository.PlanTypeRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PlanTypeFactory {
  Faker faker = new Faker();

  private final PlanTypeRepository planTypeRepository;

  public PlanTypeFactory(PlanTypeRepository planTypeRepository) {
    this.planTypeRepository = planTypeRepository;
  }

  public PlanTypeDto dtoFactory() {
    return new PlanTypeDto(faker.letterify("????????????"));
  }

  public PlanType entityFactory() {
    PlanType planType = new PlanType();
    BeanUtils.copyProperties(dtoFactory(), planType);
    planTypeRepository.save(planType);
    return planType;
  }
}
