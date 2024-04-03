package com.academy.controlacademy.factory;

import com.academy.controlacademy.dto.TrainingDto;
import com.academy.controlacademy.entity.Exercise;
import com.academy.controlacademy.entity.Training;
import com.academy.controlacademy.repository.TrainingRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
public class TrainingFactory {
    Faker faker = new Faker();
    private final UserFactory userFactory;
    private final TrainingRepository trainingRepository;
    private final ExerciseFactory exerciseFactory;

    public TrainingFactory(UserFactory userFactory, TrainingRepository trainingRepository, ExerciseFactory exerciseFactory) {
        this.userFactory = userFactory;
        this.trainingRepository = trainingRepository;
        this.exerciseFactory = exerciseFactory;
    }

    public TrainingDto dtoFactory() {
        return new TrainingDto(
                userFactory.entityFactory(),
                faker.date().birthday(),
                Set.of(exerciseFactory.entityFactory())
        );
    }

    @Transactional
    public Training entityFactory() {
        Training training = new Training();
        BeanUtils.copyProperties(dtoFactory(), training);
        trainingRepository.save(training);
        return training;
    }
}
