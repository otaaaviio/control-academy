package com.academy.controlacademy.repository;

import com.academy.controlacademy.entity.TrainingUser;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingUserRepository extends JpaRepository<TrainingUser, Long> {
  List<TrainingUser> findByUserIdAndDateBetween(Long userId, Date initial_date, Date final_date);
}
