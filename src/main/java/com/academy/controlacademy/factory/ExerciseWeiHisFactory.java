package com.academy.controlacademy.factory;

import com.academy.controlacademy.dto.ExerciseWeightHistoryDto;
import com.academy.controlacademy.entity.ExerciseWeightHistory;
import com.academy.controlacademy.repository.ExerciseWeightHistoryRepository;
import com.github.javafaker.Faker;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ExerciseWeiHisFactory {
  Faker faker = new Faker();
  private final ExerciseWeightHistoryRepository exerciseWeightHistoryRepository;
  private final ExerciseFactory exerciseFactory;
  private final UserFactory userFactory;

  public ExerciseWeiHisFactory(
      ExerciseWeightHistoryRepository exerciseWeightHistoryRepository,
      ExerciseFactory exerciseFactory,
      UserFactory userFactory) {
    this.exerciseWeightHistoryRepository = exerciseWeightHistoryRepository;
    this.exerciseFactory = exerciseFactory;
    this.userFactory = userFactory;
  }

  public ExerciseWeightHistoryDto dtoFactory() {
    return new ExerciseWeightHistoryDto(
        exerciseFactory.entityFactory(),
        faker.number().numberBetween(80, 100),
        faker.number().numberBetween(100, 120),
        faker.date().future(1, TimeUnit.DAYS),
        userFactory.entityFactory());
  }

  public ExerciseWeightHistory entityFactory() {
    ExerciseWeightHistory record = new ExerciseWeightHistory();
    BeanUtils.copyProperties(dtoFactory(), record);
    exerciseWeightHistoryRepository.save(record);
    return record;
  }
}
