package com.academy.controlacademy.factory;

import com.academy.controlacademy.dto.PlanDto;
import com.academy.controlacademy.entity.Plan;
import com.academy.controlacademy.repository.PlanRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PlanFactory {
  Faker faker = new Faker();

  private final PlanRepository planRepository;

  private final UserFactory userFactory;
  private final PlanTypeFactory planTypeFactory;
  private final CreditCardFactory creditCardFactory;

  public PlanFactory(
      PlanRepository planRepository,
      UserFactory userFactory,
      PlanTypeFactory planTypeFactory,
      CreditCardFactory creditCardFactory) {
    this.planRepository = planRepository;
    this.userFactory = userFactory;
    this.planTypeFactory = planTypeFactory;
    this.creditCardFactory = creditCardFactory;
  }

  public PlanDto dtoFactory() {
    return new PlanDto(
        userFactory.entityFactory(),
        planTypeFactory.entityFactory(),
        faker.number().randomDouble(2, 0, 100),
        faker.date().birthday(),
        creditCardFactory.entityFactory());
  }

  public Plan entityFactory() {
    Plan plan = new Plan();
    BeanUtils.copyProperties(dtoFactory(), plan);
    planRepository.save(plan);
    return plan;
  }
}
