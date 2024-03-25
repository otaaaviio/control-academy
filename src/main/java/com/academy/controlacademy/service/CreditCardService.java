package com.academy.controlacademy.service;

import com.academy.controlacademy.entity.CreditCard;
import com.academy.controlacademy.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService extends BaseService<CreditCard> {

  @Autowired
  public CreditCardService(CreditCardRepository repository) {
    super(repository);
  }
}
