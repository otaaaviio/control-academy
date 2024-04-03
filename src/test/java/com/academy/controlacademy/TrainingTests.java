package com.academy.controlacademy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.academy.controlacademy.dto.ExerciseDto;
import com.academy.controlacademy.entity.Exercise;
import com.academy.controlacademy.factory.ExerciseFactory;
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
  @Autowired private ExerciseFactory exerciseFactory;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testCreateExercise() throws Exception {
    ExerciseDto request = exerciseFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/exercises")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void testFindExercise() throws Exception {
    Exercise exercise = exerciseFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.get("/exercises/" + exercise.getId()))
        .andExpect(status().isOk());
  }

  @Test
  void testIndexExercise() throws Exception {
    exerciseFactory.entityFactory();
    exerciseFactory.entityFactory();

    mockMvc.perform(MockMvcRequestBuilders.get("/exercises")).andExpect(status().isOk());
  }

  @Test
  void testUpdateExercise() throws Exception {
    Exercise exercise = exerciseFactory.entityFactory();
    ExerciseDto request = exerciseFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/exercises/" + exercise.getId())
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testDeleteExercise() throws Exception {
    Exercise exercise = exerciseFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.delete("/exercises/" + exercise.getId()))
        .andExpect(status().isOk());
  }
}
