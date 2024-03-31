package com.academy.controlacademy.controller;

import com.academy.controlacademy.dto.PlanTypeDto;
import com.academy.controlacademy.entity.PlanType;
import com.academy.controlacademy.service.PlanTypeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan-types")
public class PlanTypeController {
  private final PlanTypeService planTypeService;

  public PlanTypeController(PlanTypeService planTypeService) {
    this.planTypeService = planTypeService;
  }

  @PostMapping
  public ResponseEntity<PlanType> createPlanType(@RequestBody @Valid PlanTypeDto request) {
    return planTypeService.create(request);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PlanType> findPlanType(@PathVariable Long id) {
    return planTypeService.findById(id);
  }

  @GetMapping
  public ResponseEntity<List<PlanType>> indexPlanType() {
    return planTypeService.index();
  }

  @PutMapping("/{id}")
  public ResponseEntity<PlanType> updatePlanType(
      @RequestBody @Valid PlanTypeDto recordDto, @PathVariable Long id) {
    return planTypeService.update(recordDto, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deletePlanType(@PathVariable Long id) {
    return planTypeService.delete(id);
  }
}
