package com.academy.controlacademy;

import com.academy.controlacademy.dto.UserDto;
import com.academy.controlacademy.entity.User;
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

    UserDto request = new UserDto("TEST USER", "111.234.333-44", birth_date, false);

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/users")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void testFindUser() throws Exception {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date birth_date = formatter.parse("01/01/1980");
    User user = new User("Test User", "111.222.333-44", birth_date, false);
    userRepository.save(user);

    mockMvc
            .perform(MockMvcRequestBuilders.get(STR."/users/\{user.getId()}"))
                    .andExpect(status().isOk());
  }

  @Test
  void testIndexUser() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(status().isOk());
  }

  @Test
  void testUpdateUser() throws Exception {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date birth_date = formatter.parse("01/01/1980");
    User user = new User("Test User", "111.222.333-44", birth_date, false);
    userRepository.save(user);

    Date updated_birth_date = formatter.parse("01/01/2000");
    UserDto updated_user = new UserDto("Updated User", "111.222.333-55", updated_birth_date, true);

    mockMvc
            .perform(MockMvcRequestBuilders.put(STR."/users/\{user.getId()}")
                    .content(objectMapper.writeValueAsString(updated_user))
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
  }

  @Test
  void testDeleteUser() throws Exception {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date birth_date = formatter.parse("01/01/1980");
    User user = new User("Test User", "222.222.333-44", birth_date, false);
    userRepository.save(user);

    mockMvc
            .perform(MockMvcRequestBuilders.delete(STR."/users/\{user.getId()}"))
            .andExpect(status().isOk());
  }
}
