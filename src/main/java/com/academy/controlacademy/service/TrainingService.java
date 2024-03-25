package com.academy.controlacademy.service;

import com.academy.controlacademy.entity.Exercise;
import com.academy.controlacademy.entity.Training;
import com.academy.controlacademy.repository.ExerciseRepository;
import com.academy.controlacademy.repository.TrainingRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService extends BaseService<Training> {
  private final ExerciseRepository exerciseRepository;
  private final TrainingRepository trainingRepository;

  @Autowired
  public TrainingService(
      TrainingRepository repository,
      ExerciseRepository exerciseRepository,
      TrainingRepository trainingRepository) {
    super(repository);
    this.exerciseRepository = exerciseRepository;
    this.trainingRepository = trainingRepository;
  }

  private void verifyExercises(Training training, Set<Long> exerciseIds) {
    Set<Exercise> exercises = new HashSet<>();
    for (Long exerciseId : exerciseIds) {
      Exercise exercise =
              exerciseRepository
                      .findById(exerciseId)
                      .orElseThrow(
                              () ->
                                      new EntityNotFoundException(
                                              STR."Não foi possível encontrar o exercício com o ID: \{exerciseId}"));
      exercises.add(exercise);
    }

    training.setExercises(exercises);
  }

  public Training createTraining(Training training, Set<Long> exerciseIds) {
    verifyExercises(training, exerciseIds);

    return trainingRepository.save(training);
  }

  public Training updateTraining(Long trainingId, Training trainingDetails, Set<Long> exerciseIds) {
    Training training = trainingRepository.findById(trainingId)
            .orElseThrow(() -> new EntityNotFoundException(STR."Não foi possível encontrar o treino com o ID: \{trainingId}"));

    verifyExercises(training, exerciseIds);
    training.setStart_date(trainingDetails.getStart_date());

    return trainingRepository.save(training);
  }

}
