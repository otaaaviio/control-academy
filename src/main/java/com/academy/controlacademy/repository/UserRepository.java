package com.academy.controlacademy.repository;

import com.academy.controlacademy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByCpf(String cpf);
    User findByName(String name);
}
