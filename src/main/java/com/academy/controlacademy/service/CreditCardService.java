package com.academy.controlacademy.service;

import com.academy.controlacademy.dto.CreditCardDto;
import com.academy.controlacademy.entity.CreditCard;
import com.academy.controlacademy.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService extends BaseService<CreditCard, CreditCardDto> {

  @Autowired
  public CreditCardService(CreditCardRepository repository) {
    super(repository);
  }

  @Override
  protected CreditCard newEntityInstance() {
    return new CreditCard();
  }
}
