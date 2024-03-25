package com.academy.controlacademy.controller;

import com.academy.controlacademy.entity.Training;
import com.academy.controlacademy.service.TrainingService;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/trainings")
public class TrainingController {
  private final TrainingService trainingService;

  @Autowired
  public TrainingController(TrainingService trainingService) {
    this.trainingService = trainingService;
  }

  @GetMapping("/{id}")
  public Training findTrainingById(@PathVariable Long id) {
    return trainingService.findById(id);
  }

  @GetMapping
  public List<Training> indexTraining() {
    return trainingService.index();
  }

  @PostMapping
  public Training createTraining(@RequestBody Training record, @RequestParam Set<Long> exerciseIds) {
    return trainingService.createTraining(record, exerciseIds);
  }

  @PutMapping("/{id}")
  public Training updateTraining(@PathVariable Long id, @RequestBody Training record, @RequestParam Set<Long> exerciseIds) {
    if (trainingService.findById(id) == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Training not found");
    }
    return trainingService.updateTraining(id, record, exerciseIds);
  }

  @DeleteMapping("/{id}")
  public void deleteTraining(@PathVariable Long id) {
    trainingService.delete(id);
  }
}
