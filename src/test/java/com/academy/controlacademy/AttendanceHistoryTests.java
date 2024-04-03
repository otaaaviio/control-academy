package com.academy.controlacademy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.academy.controlacademy.dto.AttendanceHistoryDto;
import com.academy.controlacademy.entity.AttendanceHistory;
import com.academy.controlacademy.entity.User;
import com.academy.controlacademy.factory.AttendanceHisFactory;
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
class AttendanceHistoryTests {
  @Autowired private MockMvc mockMvc;

  @Autowired private AttendanceHisFactory attendanceHisFactory;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testCreateAttendanceHistory() throws Exception {
    AttendanceHistoryDto request = attendanceHisFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/attendance-history")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void testFindByUser() throws Exception {
    AttendanceHistory record = attendanceHisFactory.entityFactory();
    User user = record.getUser();

    mockMvc
        .perform(MockMvcRequestBuilders.get("/attendance-history/" + user.getId()))
        .andExpect(status().isOk());
  }
}
