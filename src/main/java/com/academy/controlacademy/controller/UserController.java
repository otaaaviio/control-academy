package com.academy.controlacademy.controller;

import com.academy.controlacademy.dto.UserDto;
import com.academy.controlacademy.entity.User;
import com.academy.controlacademy.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody @Valid UserDto record) {
    return userService.create(record);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> findUser(@PathVariable Long id) {
    return userService.findById(id);
  }

  @GetMapping("/cpf")
  public ResponseEntity<User> findUserByCpf(@RequestParam String cpf) {
    return userService.findByCpf(cpf);
  }

  @GetMapping("/name")
  public ResponseEntity<User> findUserByName(@RequestParam String name) {
    return userService.findByName(name);
  }

  @GetMapping
  public ResponseEntity<List<User>> indexUser() {
    return userService.index();
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(
      @PathVariable Long id, @RequestBody @Valid UserDto request) {
    return userService.update(request, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
    return userService.delete(id);
  }
}
