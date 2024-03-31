package com.academy.controlacademy.controller;

import com.academy.controlacademy.dto.ExerciseDto;
import com.academy.controlacademy.entity.Exercise;
import com.academy.controlacademy.service.ExerciseService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {
  private final ExerciseService exerciseService;

  public ExerciseController(ExerciseService exerciseService) {
    this.exerciseService = exerciseService;
  }

  @PostMapping
  public ResponseEntity<Exercise> createExercise(@RequestBody @Valid ExerciseDto request) {
    return exerciseService.create(request);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Exercise> findExercise(@PathVariable Long id) {
    return exerciseService.findById(id);
  }

  @GetMapping
  public ResponseEntity<List<Exercise>> indexExercises() {
    return exerciseService.index();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Exercise> updateExercise(
      @PathVariable Long id, @RequestBody @Valid ExerciseDto request) {
    return exerciseService.update(request, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
    return exerciseService.delete(id);
  }
}
