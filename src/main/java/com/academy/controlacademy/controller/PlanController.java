package com.academy.controlacademy.controller;

import com.academy.controlacademy.entity.CreditCard;
import com.academy.controlacademy.entity.Plan;
import com.academy.controlacademy.entity.PlanType;
import com.academy.controlacademy.service.CreditCardService;
import com.academy.controlacademy.service.PlanService;
import com.academy.controlacademy.service.PlanTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/plans")
public class PlanController {
  private final PlanService planService;
  private final PlanTypeService planTypeService;
  private final CreditCardService creditCardService;

  @Autowired
  public PlanController(
      PlanService planService,
      PlanTypeService planTypeService,
      CreditCardService creditCardService) {
    this.planService = planService;
    this.planTypeService = planTypeService;
    this.creditCardService = creditCardService;
  }

  @GetMapping("/{id}")
  public Plan findPlanById(@PathVariable Long id) {
    return planService.findById(id);
  }

  @GetMapping
  public List<Plan> indexPlan() {
    return planService.index();
  }

  @PostMapping
  public Plan createPlan(@RequestBody Plan record) {
    return planService.create(record);
  }

  @PutMapping("/{id}")
  public Plan updateUser(@PathVariable Long id, @RequestBody Plan record) {
    if (planService.findById(id) == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plan not found");
    }
    return planService.update(record);
  }

  @DeleteMapping("/{id}")
  public void deletePlan(@PathVariable Long id) {
    planService.delete(id);
  }

  @GetMapping("/create-plan-type")
  public PlanType createPlanType(@RequestBody PlanType record) {
    return planTypeService.create(record);
  }

  @GetMapping("/create-credit-card")
  public CreditCard createCreditCard(@RequestBody CreditCard record) {
    return creditCardService.create(record);
  }
}
