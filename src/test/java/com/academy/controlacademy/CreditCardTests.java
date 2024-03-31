package com.academy.controlacademy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.academy.controlacademy.dto.CreditCardDto;
import com.academy.controlacademy.entity.CreditCard;
import com.academy.controlacademy.repository.CreditCardRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class CreditCardTests {
  @Autowired private MockMvc mockMvc;

  @Autowired private CreditCardRepository creditCardRepository;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testCreateCreditCard() throws Exception {
    CreditCardDto request = new CreditCardDto("1234567890123456", "123", "12/2022", "TEST USER");

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/credit-cards")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void testFindCreditCard() throws Exception {
    CreditCard creditCard = new CreditCard("1111222233334444", "123", "12/2022", "TEST USER");
    creditCardRepository.save(creditCard);
    mockMvc
        .perform(MockMvcRequestBuilders.get("/credit-cards/" + creditCard.getId()))
        .andExpect(status().isOk());
  }

  @Test
  void testIndexCreditCard() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/credit-cards")).andExpect(status().isOk());
  }

  @Test
  void testUpdateCreditCard() throws Exception {
    CreditCard creditCard = new CreditCard("0000111122223333", "123", "12/2022", "TEST USER");
    creditCardRepository.save(creditCard);
    CreditCardDto request = new CreditCardDto("1111111111111111", "123", "12/2022", "TEST USER");
    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/credit-cards/" + creditCard.getId())
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testDeleteCreditCard() throws Exception {
    CreditCard creditCard = new CreditCard("1111222933334444", "123", "12/2022", "TEST USER");
    creditCardRepository.save(creditCard);
    mockMvc
        .perform(MockMvcRequestBuilders.delete("/credit-cards/" + creditCard.getId()))
        .andExpect(status().isOk());
  }
}
