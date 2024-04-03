package com.academy.controlacademy.factory;

import com.academy.controlacademy.dto.ExerciseDto;
import com.academy.controlacademy.entity.Exercise;
import com.academy.controlacademy.entity.Muscle;
import com.academy.controlacademy.repository.ExerciseRepository;
import com.github.javafaker.Faker;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

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
    Set<Muscle> muscles = new HashSet<>();
    muscles.add(muscleFactory.entityFactory());
    muscles.add(muscleFactory.entityFactory());

    return new ExerciseDto(
        faker.letterify("????????????"),
        4,
        8,
        12,
        faker.number().numberBetween(20, 100),
        90,
        muscles);
  }

  public Exercise entityFactory() {
    Exercise exercise = new Exercise();
    BeanUtils.copyProperties(dtoFactory(), exercise);
    exerciseRepository.save(exercise);
    return exercise;
  }
}
