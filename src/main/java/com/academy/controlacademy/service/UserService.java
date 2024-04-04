package com.academy.controlacademy.service;

import com.academy.controlacademy.dto.UserDto;
import com.academy.controlacademy.entity.TrainingUser;
import com.academy.controlacademy.entity.User;
import com.academy.controlacademy.repository.TrainingUserRepository;
import com.academy.controlacademy.repository.UserRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserDto> {
  private final UserRepository userRepository;
  private final TrainingUserRepository trainingUserRepository;

  @Autowired
  public UserService(UserRepository repository, TrainingUserRepository trainingUserRepository) {
    super(repository);
    this.userRepository = repository;
    this.trainingUserRepository = trainingUserRepository;
  }

  @Override
  protected User newEntityInstance() {
    return new User();
  }

  public ResponseEntity<User> findByCpf(String cpf) {
    return ResponseEntity.status(HttpStatus.OK).body(userRepository.findByCpf(cpf));
  }

  public ResponseEntity<User> findByName(String name) {
    return ResponseEntity.status(HttpStatus.OK).body(userRepository.findByName(name));
  }

  public ResponseEntity<List<TrainingUser>> findByUserIdAndDateBetween(
      Long userId, Date initial_date, Date final_date) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(trainingUserRepository.findByUserIdAndDateBetween(userId, initial_date, final_date));
  }
}
