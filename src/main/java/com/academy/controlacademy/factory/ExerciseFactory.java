package com.academy.controlacademy.factory;

import com.academy.controlacademy.dto.ExerciseDto;
import com.academy.controlacademy.entity.Exercise;
import com.academy.controlacademy.entity.Muscle;
import com.academy.controlacademy.repository.ExerciseRepository;
import com.github.javafaker.Faker;
import java.util.Set;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ExerciseFactory {
  Faker faker = new Faker();

  private final MuscleFactory muscleFactory;
  private final ExerciseRepository exerciseRepository;

  public ExerciseFactory(MuscleFactory muscleFactory, ExerciseRepository exerciseRepository) {
    this.muscleFactory = muscleFactory;
    this.exerciseRepository = exerciseRepository;
  }

  public ExerciseDto dtoFactory() {
    return new ExerciseDto(
        faker.letterify("????????????"),
        4,
        8,
        12,
        faker.number().numberBetween(20, 100),
        90,
        Set.of(muscleFactory.entityFactory()));
  }

  @Transactional
  public Exercise entityFactory() {
    Exercise exercise = new Exercise();
    BeanUtils.copyProperties(dtoFactory(), exercise);
    exerciseRepository.save(exercise);
    return exercise;
  }
}
