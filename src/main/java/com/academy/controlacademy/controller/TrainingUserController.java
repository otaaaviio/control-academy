package com.academy.controlacademy.controller;

import com.academy.controlacademy.dto.TrainingUserDto;
import com.academy.controlacademy.entity.TrainingUser;
import com.academy.controlacademy.service.TrainingUserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training-users")
public class TrainingUserController {
  private final TrainingUserService trainingUserService;

  public TrainingUserController(TrainingUserService trainingUserService) {
    this.trainingUserService = trainingUserService;
  }

  @PostMapping
  public ResponseEntity<TrainingUser> createTrainingUser(
      @RequestBody @Valid TrainingUserDto request) {
    return trainingUserService.create(request);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TrainingUser> findTrainingUser(@PathVariable Long id) {
    return trainingUserService.findById(id);
  }

  @GetMapping
  public ResponseEntity<List<TrainingUser>> indexTrainingUser() {
    return trainingUserService.index();
  }

  @PutMapping("/{id}")
  public ResponseEntity<TrainingUser> updateTrainingUser(
      @PathVariable Long id, @RequestBody @Valid TrainingUserDto request) {
    return trainingUserService.update(request, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteTrainingUser(@PathVariable Long id) {
    return trainingUserService.delete(id);
  }
}
