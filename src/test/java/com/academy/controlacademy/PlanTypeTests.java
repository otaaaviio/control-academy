package com.academy.controlacademy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.academy.controlacademy.dto.PlanTypeDto;
import com.academy.controlacademy.entity.PlanType;
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

  @Autowired private PlanTypeRepository planTypeRepository;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testCreatePlanType() throws Exception {
    PlanTypeDto request = new PlanTypeDto("Premium");

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/plan-types")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void testFindPlanType() throws Exception {
    PlanType planType = new PlanType("Gold");
    planTypeRepository.save(planType);

    mockMvc
        .perform(MockMvcRequestBuilders.get(STR."/plan-types/\{planType.getId()}"))
        .andExpect(status().isOk());
  }

  @Test
  void testIndexPlanType() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/plan-types")).andExpect(status().isOk());
  }

  @Test
  void testUpdatePlanType() throws Exception {
    PlanType planTypeOriginal = new PlanType("Silver");
    planTypeRepository.save(planTypeOriginal);
    PlanTypeDto request = new PlanTypeDto("updated plan type");
    mockMvc
        .perform(
            MockMvcRequestBuilders.put(STR."/plan-types/\{planTypeOriginal.getId()}")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testDeletePlanType() throws Exception {
    PlanType planType = new PlanType("Bronze");
    planTypeRepository.save(planType);
    mockMvc
        .perform(MockMvcRequestBuilders.delete(STR."/plan-types/\{planType.getId()}"))
        .andExpect(status().isOk());
  }
}
