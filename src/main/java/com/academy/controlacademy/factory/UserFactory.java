package com.academy.controlacademy.factory;

import com.academy.controlacademy.dto.UserDto;
import com.academy.controlacademy.entity.User;
import com.academy.controlacademy.repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {
  Faker faker = new Faker();

  private final UserRepository userRepository;

    public UserFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto dtoFactory() {
    return new UserDto(
        faker.name().fullName(),
        faker.regexify("[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}"),
        faker.date().birthday(),
        false);
  }

  public User entityFactory() {
    User user = new User();
    BeanUtils.copyProperties(dtoFactory(), user);
    userRepository.save(user);
    return user;
  }
}
