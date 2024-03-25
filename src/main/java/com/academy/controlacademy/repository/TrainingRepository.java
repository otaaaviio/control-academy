package com.academy.controlacademy.repository;

import com.academy.controlacademy.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Long> {}
