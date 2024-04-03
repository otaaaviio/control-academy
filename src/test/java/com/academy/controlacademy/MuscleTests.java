package com.academy.controlacademy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.academy.controlacademy.dto.MuscleDto;
import com.academy.controlacademy.entity.Muscle;
import com.academy.controlacademy.factory.MuscleFactory;
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
class MuscleTests {
  @Autowired private MockMvc mockMvc;

  @Autowired private MuscleFactory muscleFactory;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testCreateMuscle() throws Exception {
    MuscleDto request = muscleFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/muscles")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void testFindMuscle() throws Exception {
    Muscle muscle = muscleFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.get("/muscles/" + muscle.getId()))
        .andExpect(status().isOk());
  }

  @Test
  void testIndexMuscle() throws Exception {
    muscleFactory.entityFactory();
    mockMvc.perform(MockMvcRequestBuilders.get("/muscles")).andExpect(status().isOk());
  }

  @Test
  void testUpdateMuscle() throws Exception {
    Muscle originalMuscle = muscleFactory.entityFactory();
    MuscleDto updatedMuscle = muscleFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/muscles/" + originalMuscle.getId())
                .content(objectMapper.writeValueAsString(updatedMuscle))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testDeleteMuscle() throws Exception {
    Muscle record = muscleFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.delete("/muscles/" + record.getId()))
        .andExpect(status().isOk());
  }
}
