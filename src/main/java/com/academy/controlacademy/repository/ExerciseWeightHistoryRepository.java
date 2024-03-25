package com.academy.controlacademy.repository;

import com.academy.controlacademy.entity.ExerciseWeightHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseWeightHistoryRepository extends JpaRepository<ExerciseWeightHistory, Long> {
    List<ExerciseWeightHistory> findByUserId(Long userId);
}
