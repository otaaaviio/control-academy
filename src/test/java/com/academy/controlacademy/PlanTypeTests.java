package com.academy.controlacademy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.academy.controlacademy.dto.PlanTypeDto;
import com.academy.controlacademy.entity.PlanType;
import com.academy.controlacademy.factory.PlanTypeFactory;
import com.academy.controlacademy.repository.PlanTypeRepository;
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
class PlanTypeTests {
  @Autowired private MockMvc mockMvc;
  @Autowired private PlanTypeFactory planTypeFactory;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testCreatePlanType() throws Exception {
    PlanTypeDto request = planTypeFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/plan-types")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void testFindPlanType() throws Exception {
    PlanType planType = planTypeFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.get("/plan-types/" + planType.getId()))
        .andExpect(status().isOk());
  }

  @Test
  void testIndexPlanType() throws Exception {
    planTypeFactory.entityFactory();
    planTypeFactory.entityFactory();

    mockMvc.perform(MockMvcRequestBuilders.get("/plan-types")).andExpect(status().isOk());
  }

  @Test
  void testUpdatePlanType() throws Exception {
    PlanType planTypeOriginal = planTypeFactory.entityFactory() ;
    PlanTypeDto request = planTypeFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/plan-types/" + planTypeOriginal.getId())
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testDeletePlanType() throws Exception {
    PlanType planType = planTypeFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.delete("/plan-types/" + planType.getId()))
        .andExpect(status().isOk());
  }
}
