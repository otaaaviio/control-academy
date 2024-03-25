package com.academy.controlacademy.controller;

import com.academy.controlacademy.entity.AttendanceHistory;
import com.academy.controlacademy.entity.User;
import com.academy.controlacademy.service.AttendanceHistoryService;
import com.academy.controlacademy.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;
  private final AttendanceHistoryService attendanceHistoryService;

  @Autowired
  public UserController(
      UserService userService, AttendanceHistoryService attendanceHistoryService) {
    this.userService = userService;
    this.attendanceHistoryService = attendanceHistoryService;
  }

  @GetMapping("/{id}")
  public User findUserById(@PathVariable Long id) {
    return userService.findById(id);
  }

  @GetMapping
  public List<User> indexUser() {
    return userService.index();
  }

  @PostMapping
  public User createUser(@RequestBody User record) {
    return userService.create(record);
  }

  @PutMapping("/{id}")
  public User updateUser(@PathVariable Long id, @RequestBody User record) {
    if (userService.findById(id) == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
    return userService.update(record);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id) {
    userService.delete(id);
  }

  @PostMapping("/attendance-history")
  public AttendanceHistory registerAttendance(@RequestBody AttendanceHistory record) {
    return attendanceHistoryService.create(record);
  }

  @GetMapping("/attendance-history/{id}")
  public List<AttendanceHistory> showUserAttendanceHistory(@PathVariable Long id) {
    return attendanceHistoryService.findByUser(id);
  }

  @DeleteMapping("/attendance-history/{id}")
  public void deleteAttendanceHistory(@PathVariable Long id) {
    attendanceHistoryService.delete(id);
  }
}
