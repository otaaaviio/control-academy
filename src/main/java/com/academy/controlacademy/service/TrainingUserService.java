package com.academy.controlacademy.service;

import com.academy.controlacademy.dto.TrainingUserDto;
import com.academy.controlacademy.entity.TrainingUser;
import com.academy.controlacademy.repository.TrainingUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingUserService extends BaseService<TrainingUser, TrainingUserDto> {
  @Autowired
  public TrainingUserService(TrainingUserRepository repository) {
    super(repository);
  }

  @Override
  protected TrainingUser newEntityInstance() {
    return new TrainingUser();
  }
}
