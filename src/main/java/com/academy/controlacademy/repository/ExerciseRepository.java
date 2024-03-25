package com.academy.controlacademy.repository;

import com.academy.controlacademy.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {}
