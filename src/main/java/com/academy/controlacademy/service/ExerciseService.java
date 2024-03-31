package com.academy.controlacademy.service;

import com.academy.controlacademy.dto.ExerciseDto;
import com.academy.controlacademy.entity.Exercise;
import com.academy.controlacademy.repository.ExerciseRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {
  private final ExerciseRepository exerciseRepository;

  @Autowired
  public ExerciseService(ExerciseRepository repository) {
    this.exerciseRepository = repository;
  }

  private void setExercise(Exercise exercise, ExerciseDto request) {
    exercise.setMax_reps(request.max_reps());
    exercise.setMin_reps(request.min_reps());
    exercise.setNum_series(request.num_series());
    exercise.setRest_time(request.rest_time());
    exercise.setWeight(request.weight());
    exercise.setMuscles(request.muscles());
  }

  public ResponseEntity<Exercise> create(ExerciseDto request) {
    Exercise exercise = new Exercise();

    setExercise(exercise, request);

    return ResponseEntity.status(HttpStatus.CREATED).body(exerciseRepository.save(exercise));
  }

  public ResponseEntity<Exercise> findById(Long id) {
    Optional<Exercise> record = exerciseRepository.findById(id);
    return record
        .map(e -> ResponseEntity.status(HttpStatus.OK).body(e))
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
  }

  public ResponseEntity<List<Exercise>> index() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(exerciseRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
  }

  public ResponseEntity<Exercise> update(ExerciseDto request, Long id) {
    Exercise exercise =
        exerciseRepository
            .findById(id)
            .orElseThrow(
                () -> new EntityNotFoundException(STR."Unable to find exercise with ID: \{id}"));

    setExercise(exercise, request);

    return ResponseEntity.status(HttpStatus.OK).body(exerciseRepository.save(exercise));
  }

  public ResponseEntity<Object> delete(Long id) {
    Optional<Exercise> record = exerciseRepository.findById(id);
    if (record.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    exerciseRepository.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body("Record deleted successfully");
  }
}
