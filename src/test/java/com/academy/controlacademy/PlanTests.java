package com.academy.controlacademy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.academy.controlacademy.dto.PlanDto;
import com.academy.controlacademy.entity.Plan;
import com.academy.controlacademy.factory.PlanFactory;
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
class PlanTests {
  @Autowired private MockMvc mockMvc;
  @Autowired private PlanFactory planFactory;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testCreatePlan() throws Exception {
    PlanDto record = planFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/plans")
                .content(objectMapper.writeValueAsString(record))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void testFindPlan() throws Exception {
    Plan record = planFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.get("/plans/" + record.getId()))
        .andExpect(status().isOk());
  }

  @Test
  void testIndexPlan() throws Exception {
    planFactory.entityFactory();
    planFactory.entityFactory();

    mockMvc.perform(MockMvcRequestBuilders.get("/plans")).andExpect(status().isOk());
  }

  @Test
  void testUpdatePlan() throws Exception {
    Plan originalRecord = planFactory.entityFactory();
    PlanDto record = planFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/plans/" + originalRecord.getId())
                .content(objectMapper.writeValueAsString(record))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testDeletePlan() throws Exception {
    Plan record = planFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.delete("/plans/" + record.getId()))
        .andExpect(status().isOk());
  }
}
