package com.academy.controlacademy.factory;

import com.academy.controlacademy.dto.MuscleDto;
import com.academy.controlacademy.entity.Muscle;
import com.academy.controlacademy.repository.MuscleRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MuscleFactory {
  Faker faker = new Faker();

  private final MuscleRepository muscleRepository;

  public MuscleFactory(MuscleRepository muscleRepository) {
    this.muscleRepository = muscleRepository;
  }

  public MuscleDto dtoFactory() {
      return new MuscleDto(faker.letterify("????????????"));
  }

  @Transactional
  public Muscle entityFactory() {
    Muscle muscle = new Muscle();
    BeanUtils.copyProperties(dtoFactory(), muscle);
    muscleRepository.save(muscle);
    return muscle;
  }
}
