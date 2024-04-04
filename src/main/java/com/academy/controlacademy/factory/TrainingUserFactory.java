package com.academy.controlacademy.factory;

import com.academy.controlacademy.dto.TrainingUserDto;
import com.academy.controlacademy.entity.TrainingUser;
import com.academy.controlacademy.repository.TrainingUserRepository;
import com.github.javafaker.Faker;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TrainingUserFactory {
  Faker faker = new Faker();

  private final TrainingUserRepository trainingUserRepository;
  private final UserFactory userFactory;
  private final TrainingFactory trainingFactory;

  public TrainingUserFactory(
      TrainingUserRepository trainingUserRepository,
      UserFactory userFactory,
      TrainingFactory trainingFactory) {
    this.trainingUserRepository = trainingUserRepository;
    this.userFactory = userFactory;
    this.trainingFactory = trainingFactory;
  }

  public TrainingUserDto dtoFactory() {
    return new TrainingUserDto(
        userFactory.entityFactory(),
        trainingFactory.entityFactory(),
        faker.date().future(1, TimeUnit.HOURS));
  }

  public TrainingUser entityFactory() {
    TrainingUser trainingUser = new TrainingUser();
    BeanUtils.copyProperties(dtoFactory(), trainingUser);
    trainingUserRepository.save(trainingUser);
    return trainingUser;
  }
}
