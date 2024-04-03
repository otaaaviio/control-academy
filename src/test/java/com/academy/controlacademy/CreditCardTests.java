package com.academy.controlacademy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.academy.controlacademy.dto.CreditCardDto;
import com.academy.controlacademy.entity.CreditCard;
import com.academy.controlacademy.factory.CreditCardFactory;
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

  @Autowired private CreditCardFactory creditCardFactory;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testCreateCreditCard() throws Exception {
    CreditCardDto request = creditCardFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/credit-cards")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void testFindCreditCard() throws Exception {
    CreditCard creditCard = creditCardFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.get("/credit-cards/" + creditCard.getId()))
        .andExpect(status().isOk());
  }

  @Test
  void testIndexCreditCard() throws Exception {
    creditCardFactory.entityFactory();
    creditCardFactory.entityFactory();

    mockMvc.perform(MockMvcRequestBuilders.get("/credit-cards")).andExpect(status().isOk());
  }

  @Test
  void testUpdateCreditCard() throws Exception {
    CreditCard creditCard = creditCardFactory.entityFactory();
    CreditCardDto request = creditCardFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/credit-cards/" + creditCard.getId())
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testDeleteCreditCard() throws Exception {
    CreditCard creditCard = creditCardFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.delete("/credit-cards/" + creditCard.getId()))
        .andExpect(status().isOk());
  }
}
