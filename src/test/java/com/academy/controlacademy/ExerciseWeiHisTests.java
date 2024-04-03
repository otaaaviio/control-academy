package com.academy.controlacademy;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ExerciseWeiHisTests {
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() throws ParseException {
        this.objectMapper = new ObjectMapper();
    }

//    @Test
//    void testCreatePlan() throws Exception {
//        PlanDto record = new PlanDto(user, plan_type, 120.22, date, creditCard);
//        String json = objectMapper.writeValueAsString(record);
//        System.out.println(json);
//        mockMvc
//                .perform(
//                        MockMvcRequestBuilders.post("/plans")
//                        .content(objectMapper.writeValueAsString(record))
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated());
//    }
}
