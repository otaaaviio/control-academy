package com.academy.controlacademy;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.academy.controlacademy.dto.UserDto;
import com.academy.controlacademy.entity.User;
import com.academy.controlacademy.factory.UserFactory;
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
class UserTests {
  @Autowired private MockMvc mockMvc;

  @Autowired private UserFactory userFactory;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    this.objectMapper = new ObjectMapper();
  }

  @Test
  void testCreateUser() throws Exception {
    UserDto request = userFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/users")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  void testFindUser() throws Exception {
    User user = userFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.get("/users/" + user.getId()))
        .andExpect(status().isOk());
  }

  @Test
  void testFindUserByName() throws Exception {
    User user = userFactory.entityFactory();

    mockMvc
            .perform(MockMvcRequestBuilders.get("/users/name").param("name", user.getName()))
            .andExpect(status().isOk());
  }

  @Test
  void testFindUserByCpf() throws Exception {
    User user = userFactory.entityFactory();

    mockMvc
            .perform(MockMvcRequestBuilders.get("/users/cpf").param("cpf", user.getCpf()))
            .andExpect(status().isOk());
  }

  @Test
  void testIndexUser() throws Exception {
    userFactory.entityFactory();
    userFactory.entityFactory();

    mockMvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(status().isOk());
  }

  @Test
  void testUpdateUser() throws Exception {
    User user = userFactory.entityFactory();
    UserDto updated_user = userFactory.dtoFactory();

    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/users/" + user.getId())
                .content(objectMapper.writeValueAsString(updated_user))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testDeleteUser() throws Exception {
    User user = userFactory.entityFactory();

    mockMvc
        .perform(MockMvcRequestBuilders.delete("/users/" + user.getId()))
        .andExpect(status().isOk());
  }
}
