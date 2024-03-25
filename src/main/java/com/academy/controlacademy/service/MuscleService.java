package com.academy.controlacademy.service;

import com.academy.controlacademy.entity.Muscle;
import com.academy.controlacademy.repository.MuscleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuscleService extends BaseService<Muscle> {

  @Autowired
  public MuscleService(MuscleRepository repository) {
    super(repository);
  }
}
