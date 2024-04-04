package com.academy.controlacademy.controller;

import com.academy.controlacademy.dto.TrainingDto;
import com.academy.controlacademy.entity.Training;
import com.academy.controlacademy.service.TrainingService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainings")
public class TrainingController {
  private final TrainingService trainingService;

  @Autowired
  public TrainingController(TrainingService trainingService) {
    this.trainingService = trainingService;
  }

  @PostMapping
  public ResponseEntity<Training> createTraining(@RequestBody @Valid TrainingDto request) {
    return trainingService.create(request);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Training> findTraining(@PathVariable Long id) {
    return trainingService.findById(id);
  }

  @GetMapping
  public ResponseEntity<List<Training>> indexTraining() {
    return trainingService.index();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Training> updateTraining(
      @PathVariable Long id, @RequestBody @Valid TrainingDto request) {
    return trainingService.update(request, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteTraining(@PathVariable Long id) {
    return trainingService.delete(id);
  }
}
