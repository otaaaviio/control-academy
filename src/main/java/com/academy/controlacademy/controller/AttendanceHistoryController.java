package com.academy.controlacademy.controller;

import com.academy.controlacademy.dto.AttendanceHistoryDto;
import com.academy.controlacademy.entity.AttendanceHistory;
import com.academy.controlacademy.service.AttendanceHistoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance-history")
public class AttendanceHistoryController {
  private final AttendanceHistoryService attendanceHistoryService;

  public AttendanceHistoryController(AttendanceHistoryService attendanceHistoryService) {
    this.attendanceHistoryService = attendanceHistoryService;
  }

  @PostMapping
  public ResponseEntity<AttendanceHistory> createAttendanceHistory(
      @RequestBody @Valid AttendanceHistoryDto request) {
    return attendanceHistoryService.create(request);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<List<AttendanceHistory>> findAttendanceHistory(@PathVariable Long userId) {
    return attendanceHistoryService.findByUser(userId);
  }

  @PutMapping("/{id}")
  public ResponseEntity<AttendanceHistory> updateAttendanceHistory(
      @RequestBody @Valid AttendanceHistoryDto request, @PathVariable Long id) {
    return attendanceHistoryService.update(request, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteAttendanceHistory(@PathVariable Long id) {
    return attendanceHistoryService.delete(id);
  }
}
