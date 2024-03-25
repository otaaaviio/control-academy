package com.academy.controlacademy.service;

import com.academy.controlacademy.entity.AttendanceHistory;
import com.academy.controlacademy.entity.ExerciseWeightHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.academy.controlacademy.repository.AttendanceHistoryRepository;

import java.util.List;

@Service
public class AttendanceHistoryService extends BaseService<AttendanceHistory> {

  private final AttendanceHistoryRepository repository;

  @Autowired
  public AttendanceHistoryService(
      AttendanceHistoryRepository repository, AttendanceHistoryRepository repository1) {
    super(repository);
    this.repository = repository1;
  }

  public List<AttendanceHistory> findByUser(Long userId) {
    return repository.findByUserId(userId);
  }
}
