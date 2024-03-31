package com.academy.controlacademy.service;

import com.academy.controlacademy.dto.AttendanceHistoryDto;
import com.academy.controlacademy.entity.AttendanceHistory;
import com.academy.controlacademy.repository.AttendanceHistoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AttendanceHistoryService extends BaseService<AttendanceHistory, AttendanceHistoryDto> {

  private final AttendanceHistoryRepository attHisRepository;

  @Autowired
  public AttendanceHistoryService(AttendanceHistoryRepository repository) {
    super(repository);
    this.attHisRepository = repository;
  }

  @Override
  protected AttendanceHistory newEntityInstance() {
    return new AttendanceHistory();
  }

  public ResponseEntity<List<AttendanceHistory>> findByUser(Long userId) {
    return ResponseEntity.status(HttpStatus.OK).body(attHisRepository.findByUserId(userId));
  }
}
