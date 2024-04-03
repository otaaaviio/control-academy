package com.academy.controlacademy.service;

import com.academy.controlacademy.dto.UserDto;
import com.academy.controlacademy.entity.User;
import com.academy.controlacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserDto> {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository repository) {
    super(repository);
    this.userRepository = repository;
  }

  @Override
  protected User newEntityInstance() {
    return new User();
  }

  public ResponseEntity<User> findByCpf(String cpf) {
    return ResponseEntity.status(HttpStatus.OK).body(userRepository.findByCpf(cpf));
  }

  public ResponseEntity<User>  findByName(String name) {
    return ResponseEntity.status(HttpStatus.OK).body(userRepository.findByName(name));
  }
}
