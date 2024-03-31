package com.academy.controlacademy.controller;

import com.academy.controlacademy.dto.ExerciseWeightHistoryDto;
import com.academy.controlacademy.entity.ExerciseWeightHistory;
import com.academy.controlacademy.service.ExerciseWeightHistoryService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weight-history")
public class ExerciseWeightHistoryController {
  private final ExerciseWeightHistoryService exerciseWeightHistoryService;

  public ExerciseWeightHistoryController(
      ExerciseWeightHistoryService exerciseWeightHistoryService) {
    this.exerciseWeightHistoryService = exerciseWeightHistoryService;
  }

  @PostMapping
  public ResponseEntity<ExerciseWeightHistory> createWeightHistory(
      @RequestBody @Valid ExerciseWeightHistoryDto request) {
    return exerciseWeightHistoryService.create(request);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<List<ExerciseWeightHistory>> findWeightHistory(@PathVariable Long userId) {
    return exerciseWeightHistoryService.findByUser(userId);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ExerciseWeightHistory> updateWeightHistory(
      @RequestBody @Valid ExerciseWeightHistoryDto request, @PathVariable Long id) {
    return exerciseWeightHistoryService.update(request, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteWeightHistory(@PathVariable Long id) {
    return exerciseWeightHistoryService.delete(id);
  }
}
