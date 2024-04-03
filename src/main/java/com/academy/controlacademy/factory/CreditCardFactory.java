package com.academy.controlacademy.factory;

import com.academy.controlacademy.dto.CreditCardDto;
import com.academy.controlacademy.entity.CreditCard;
import com.academy.controlacademy.repository.CreditCardRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CreditCardFactory {
  Faker faker = new Faker();

  private final CreditCardRepository creditCardRepository;

    public CreditCardFactory(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCardDto dtoFactory() {
    return new CreditCardDto(
        faker.number().digits(16),
        faker.regexify("[0-9]{3}"),
        faker.regexify("[0-9]{2}/[0-9]{4}"),
        faker.name().fullName());
  }

  public CreditCard entityFactory() {
    CreditCard creditCard = new CreditCard();
    BeanUtils.copyProperties(dtoFactory(), creditCard);
    creditCardRepository.save(creditCard);
    return creditCard;
  }
}
