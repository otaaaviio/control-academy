package com.academy.controlacademy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.academy.controlacademy.dto.ExerciseWeightHistoryDto;
import com.academy.controlacademy.entity.ExerciseWeightHistory;
import com.academy.controlacademy.entity.User;
import com.academy.controlacademy.factory.ExerciseWeiHisFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.ParseException;
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
class ExerciseWeiHisTests {
  @Autowired private MockMvc mockMvc;
  @Autowired private ExerciseWeiHisFactory exerciseWeiHisFactory;

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() throws ParseException {
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testCreateExerciseWeiHis() throws Exception {
    ExerciseWeightHistoryDto request = exerciseWeiHisFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/weight-history")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void testFindByUser() throws Exception {
    ExerciseWeightHistory record = exerciseWeiHisFactory.entityFactory();
    User user = record.getUser();

    mockMvc
        .perform(MockMvcRequestBuilders.get("/weight-history/" + user.getId()))
        .andExpect(status().isOk());
  }
}
