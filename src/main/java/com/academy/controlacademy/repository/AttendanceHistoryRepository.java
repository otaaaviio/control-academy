package com.academy.controlacademy.repository;

import com.academy.controlacademy.entity.AttendanceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceHistoryRepository extends JpaRepository<AttendanceHistory, Long> {
    List<AttendanceHistory> findByUserId(Long userId);
}
