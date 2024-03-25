package com.academy.controlacademy.service;

import com.academy.controlacademy.entity.User;
import com.academy.controlacademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User> {

  @Autowired
  public UserService(UserRepository repository) {
    super(repository);
  }
}
