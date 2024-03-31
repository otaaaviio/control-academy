package com.academy.controlacademy;

import com.academy.controlacademy.dto.UserDto;
import com.academy.controlacademy.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserTests {
  @Autowired private MockMvc mockMvc;

  @Autowired private UserRepository userRepository;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testCreateUser() throws Exception {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date birth_date = formatter.parse("01/01/1980");

    UserDto request = new UserDto("TEST USER", "111.222.333-44", birth_date, false);

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/users")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }
}
