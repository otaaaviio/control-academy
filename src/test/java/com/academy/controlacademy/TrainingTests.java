package com.academy.controlacademy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.academy.controlacademy.dto.TrainingDto;
import com.academy.controlacademy.entity.Training;
import com.academy.controlacademy.factory.TrainingFactory;
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
class TrainingTests {
  @Autowired private MockMvc mockMvc;
  @Autowired private TrainingFactory trainingFactory;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testCreateTraining() throws Exception {
    TrainingDto request = trainingFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/trainings")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void testFindTraining() throws Exception {
    Training training = trainingFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.get("/trainings/" + training.getId()))
        .andExpect(status().isOk());
  }

  @Test
  void testIndexTraining() throws Exception {
    trainingFactory.entityFactory();
    trainingFactory.entityFactory();

    mockMvc.perform(MockMvcRequestBuilders.get("/trainings")).andExpect(status().isOk());
  }

  @Test
  void testUpdateTraining() throws Exception {
    Training training = trainingFactory.entityFactory();
    TrainingDto request = trainingFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/trainings/" + training.getId())
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testDeleteTraining() throws Exception {
    Training training = trainingFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.delete("/trainings/" + training.getId()))
        .andExpect(status().isOk());
  }
}
