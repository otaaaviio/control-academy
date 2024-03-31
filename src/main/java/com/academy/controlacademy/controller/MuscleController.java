package com.academy.controlacademy.controller;

import com.academy.controlacademy.dto.MuscleDto;
import com.academy.controlacademy.entity.Muscle;
import com.academy.controlacademy.service.MuscleService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/muscles")
public class MuscleController {
  private final MuscleService muscleService;

  public MuscleController(MuscleService muscleService) {
    this.muscleService = muscleService;
  }

  @PostMapping
  public ResponseEntity<Muscle> createMuscle(@RequestBody @Valid MuscleDto request) {
    return muscleService.create(request);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Muscle> findMuscle(@PathVariable Long id) {
    return muscleService.findById(id);
  }

  @GetMapping
  public ResponseEntity<List<Muscle>> indexMuscle() {
    return muscleService.index();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Muscle> updateMuscle(
      @RequestBody @Valid MuscleDto request, @PathVariable Long id) {
    return muscleService.update(request, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteMuscle(@PathVariable Long id) {
    return muscleService.delete(id);
  }
}
