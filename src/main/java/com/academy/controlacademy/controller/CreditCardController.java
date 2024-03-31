package com.academy.controlacademy.controller;

import com.academy.controlacademy.dto.CreditCardDto;
import com.academy.controlacademy.entity.CreditCard;
import com.academy.controlacademy.service.CreditCardService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {
  private final CreditCardService creditCardService;

  public CreditCardController(CreditCardService creditCardService) {
    this.creditCardService = creditCardService;
  }

  @PostMapping
  public ResponseEntity<CreditCard> createCreditCard(@RequestBody @Valid CreditCardDto request) {
    return creditCardService.create(request);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CreditCard> findCreditCard(@PathVariable Long id) {
    return creditCardService.findById(id);
  }

  @GetMapping
  public ResponseEntity<List<CreditCard>> indexCreditCard() {
    return creditCardService.index();
  }

  @PutMapping("/{id}")
  public ResponseEntity<CreditCard> updateCreditCard(
      @PathVariable Long id, @RequestBody @Valid CreditCardDto request) {
    return creditCardService.update(request, id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteCreditCard(@PathVariable Long id) {
    return creditCardService.delete(id);
  }
}
