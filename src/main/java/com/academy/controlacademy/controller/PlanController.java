package com.academy.controlacademy.controller;

import com.academy.controlacademy.dto.PlanDto;
import com.academy.controlacademy.entity.Plan;
import com.academy.controlacademy.service.PlanService;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/plans")
public class PlanController {
  private final PlanService planService;

  @Autowired
  public PlanController(PlanService planService) {
    this.planService = planService;
  }

  @PostMapping
  public ResponseEntity<Plan> createPlan(@RequestBody @Valid PlanDto request) {
    return planService.create(request);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Plan> findPlan(@PathVariable Long id) {
    return planService.findById(id);
  }

  @GetMapping
  public ResponseEntity<List<Plan>> indexPlan() {
    return planService.index();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Plan> updatePlan(@PathVariable Long id, @RequestBody @Valid PlanDto request) {
    return planService.update(request, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deletePlan(@PathVariable Long id) {
    return planService.delete(id);
  }
}
