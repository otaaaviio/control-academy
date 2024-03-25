package com.academy.controlacademy.service;

import com.academy.controlacademy.entity.ExerciseWeightHistory;
import com.academy.controlacademy.repository.ExerciseWeightHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseWeightHistoryService extends BaseService<ExerciseWeightHistory> {

    private final ExerciseWeightHistoryRepository repository;

    @Autowired
    public ExerciseWeightHistoryService(ExerciseWeightHistoryRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<ExerciseWeightHistory> findByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}
