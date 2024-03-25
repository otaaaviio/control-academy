package com.academy.controlacademy.repository;

import com.academy.controlacademy.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {}
