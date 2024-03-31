package com.academy.controlacademy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.academy.controlacademy.dto.MuscleDto;
import com.academy.controlacademy.entity.Muscle;
import com.academy.controlacademy.repository.MuscleRepository;
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

  @Autowired private MuscleRepository muscleRepository;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testCreateMuscle() throws Exception {
    MuscleDto request = new MuscleDto("muscle");

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/muscles")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void testFindPlanType() throws Exception {
    Muscle muscle = new Muscle("muscle");
    muscleRepository.save(muscle);

    mockMvc
        .perform(MockMvcRequestBuilders.get("/muscles/" + muscle.getId()))
        .andExpect(status().isOk());
  }

  @Test
  void testIndexMuscle() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/muscles")).andExpect(status().isOk());
  }

  @Test
  void testUpdateMuscle() throws Exception {
    Muscle muscleOriginal = new Muscle("muscle");
    muscleRepository.save(muscleOriginal);
    MuscleDto request = new MuscleDto("updated muscle");
    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/muscles/" + muscleOriginal.getId())
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testDeletePlanType() throws Exception {
    Muscle record = new Muscle("muscle");
    muscleRepository.save(record);
    mockMvc
        .perform(MockMvcRequestBuilders.delete("/muscles/" + record.getId()))
        .andExpect(status().isOk());
  }
}
