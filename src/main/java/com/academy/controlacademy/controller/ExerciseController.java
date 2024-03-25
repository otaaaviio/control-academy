package com.academy.controlacademy.controller;

import com.academy.controlacademy.entity.Exercise;
import com.academy.controlacademy.entity.ExerciseWeightHistory;
import com.academy.controlacademy.service.ExerciseService;
import com.academy.controlacademy.service.ExerciseWeightHistoryService;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {
  private final ExerciseService exerciseService;
  private final ExerciseWeightHistoryService exerciseWeightHistoryService;

  public ExerciseController(
      ExerciseService exerciseService, ExerciseWeightHistoryService exerciseWeightHistoryService) {
    this.exerciseService = exerciseService;
    this.exerciseWeightHistoryService = exerciseWeightHistoryService;
  }

  @GetMapping("/{id}")
  public Exercise findExerciseById(@PathVariable Long id) {
    return exerciseService.findById(id);
  }

  @GetMapping
  public List<Exercise> indexExercises() {
    return exerciseService.index();
  }

  @PostMapping
  public Exercise createExercise(@RequestBody Exercise record, @RequestParam Set<Long> muscleIds) {
    return exerciseService.createExercise(record, muscleIds);
  }

  @PutMapping("/{id}")
  public Exercise updateExercise(@PathVariable Long id, @RequestBody Exercise record, @RequestParam Set<Long> muscleIds) {
    if (exerciseService.findById(id) == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercise not found");
    }
    return exerciseService.updateExercise(id, record, muscleIds);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id) {
    exerciseService.delete(id);
  }

  @PostMapping("/weight-history")
  public ExerciseWeightHistory registerWeightHistory(@RequestBody ExerciseWeightHistory record) {
    return exerciseWeightHistoryService.create(record);
  }

  @GetMapping("/weight-history/{id}")
  public List<ExerciseWeightHistory> showUserWeightHistory(@PathVariable Long id) {
    return exerciseWeightHistoryService.findByUser(id);
  }

  @DeleteMapping("/weight-history/{id}")
  public void deleteWeightHistory(@PathVariable Long id) {
    exerciseWeightHistoryService.delete(id);
  }
}
