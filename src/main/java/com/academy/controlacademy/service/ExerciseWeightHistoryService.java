package com.academy.controlacademy.service;

import com.academy.controlacademy.dto.ExerciseWeightHistoryDto;
import com.academy.controlacademy.entity.ExerciseWeightHistory;
import com.academy.controlacademy.repository.ExerciseWeightHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseWeightHistoryService
    extends BaseService<ExerciseWeightHistory, ExerciseWeightHistoryDto> {

  private final ExerciseWeightHistoryRepository repository;

  @Autowired
  public ExerciseWeightHistoryService(ExerciseWeightHistoryRepository repository) {
    super(repository);
    this.repository = repository;
  }

  @Override
  protected ExerciseWeightHistory newEntityInstance() {
    return new ExerciseWeightHistory();
  }

  public ResponseEntity<List<ExerciseWeightHistory>> findByUser(Long userId) {
    return ResponseEntity.status(HttpStatus.OK).body(repository.findByUserId(userId));
  }
}
