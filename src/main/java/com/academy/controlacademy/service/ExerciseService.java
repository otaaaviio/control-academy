package com.academy.controlacademy.service;

import com.academy.controlacademy.entity.Exercise;
import com.academy.controlacademy.entity.Muscle;
import com.academy.controlacademy.entity.Training;
import com.academy.controlacademy.repository.ExerciseRepository;
import com.academy.controlacademy.repository.MuscleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExerciseService extends BaseService<Exercise> {
  private final ExerciseRepository exerciseRepository;
  private final MuscleRepository muscleRepository;

  @Autowired
  public ExerciseService(ExerciseRepository repository, ExerciseRepository exerciseRepository, MuscleRepository muscleRepository) {
    super(repository);
    this.exerciseRepository = exerciseRepository;
      this.muscleRepository = muscleRepository;
  }

  private void verifyMuscles(Exercise exercise, Set<Long> muscleIds) {
    Set<Muscle> muscles = new HashSet<>();
    for (Long muscleId : muscleIds) {
      Muscle muscle =
              muscleRepository
                      .findById(muscleId)
                      .orElseThrow(
                              () ->
                                      new EntityNotFoundException(
                                              STR."Não foi possível encontrar o músculo com o ID: \{muscleId}"));
      muscles.add(muscle);
    }

    exercise.setMuscles(muscles);
  }

  public Exercise createExercise(Exercise exercise, Set<Long> muscleIds) {
    verifyMuscles(exercise, muscleIds);

    return exerciseRepository.save(exercise);
  }

  public Exercise updateExercise(Long exerciseId, Exercise exerciseDetails, Set<Long> muscleIds) {
    Exercise exercise = exerciseRepository.findById(exerciseId)
            .orElseThrow(() -> new EntityNotFoundException(STR."Não foi possível encontrar o exercício com o ID: \{exerciseId}"));

    verifyMuscles(exercise, muscleIds);

    exercise.setNum_series(exerciseDetails.getNum_series());
    exercise.setMin_reps(exerciseDetails.getMin_reps());
    exercise.setMax_reps(exerciseDetails.getMax_reps());
    exercise.setWeight(exerciseDetails.getWeight());
    exercise.setRest_time(exerciseDetails.getRest_time());

    return exerciseRepository.save(exercise);
  }
}
