package com.academy.controlacademy.factory;

import com.academy.controlacademy.dto.TrainingDto;
import com.academy.controlacademy.entity.Exercise;
import com.academy.controlacademy.entity.Training;
import com.academy.controlacademy.repository.TrainingRepository;
import com.github.javafaker.Faker;
import java.util.Set;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TrainingFactory {
  Faker faker = new Faker();
  private final UserFactory userFactory;
  private final TrainingRepository trainingRepository;
  private final ExerciseFactory exerciseFactory;

  public TrainingFactory(
      UserFactory userFactory,
      TrainingRepository trainingRepository,
      ExerciseFactory exerciseFactory) {
    this.userFactory = userFactory;
    this.trainingRepository = trainingRepository;
    this.exerciseFactory = exerciseFactory;
  }

  public TrainingDto dtoFactory() {
    Exercise exercise = exerciseFactory.entityFactory();
    return new TrainingDto(userFactory.entityFactory(), faker.date().birthday(), Set.of(exercise));
  }

  @Transactional
  public Training entityFactory() {
    Training training = new Training();
    BeanUtils.copyProperties(dtoFactory(), training);
    trainingRepository.save(training);
    return training;
  }
}
