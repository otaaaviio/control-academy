package com.academy.controlacademy.factory;

import com.academy.controlacademy.dto.AttendanceHistoryDto;
import com.academy.controlacademy.entity.AttendanceHistory;
import com.academy.controlacademy.repository.AttendanceHistoryRepository;
import com.github.javafaker.Faker;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AttendanceHisFactory {
  Faker faker = new Faker();

  private final AttendanceHistoryRepository attendanceHistoryRepository;
  private final UserFactory userFactory;

  public AttendanceHisFactory(
      AttendanceHistoryRepository attendanceHistoryRepository, UserFactory userFactory) {
    this.attendanceHistoryRepository = attendanceHistoryRepository;
    this.userFactory = userFactory;
  }

  public AttendanceHistoryDto dtoFactory() {
    return new AttendanceHistoryDto(
        userFactory.entityFactory(), faker.date().future(1, TimeUnit.DAYS));
  }

  public AttendanceHistory entityFactory() {
    AttendanceHistory record = new AttendanceHistory();
    BeanUtils.copyProperties(dtoFactory(), record);
    attendanceHistoryRepository.save(record);
    return record;
  }
}
