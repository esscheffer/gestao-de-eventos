package com.example.gestaoeventos.controller;

import com.example.gestaoeventos.dto.EventDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class EventsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateEventAndRetrieveIt() throws Exception {
        EventDTO eventDTO = EventDTO.builder()
                .title("Test Event")
                .description("Test description")
                .dateTime(ZonedDateTime.now())
                .location("Test Location")
                .build();

        MvcResult insertResult = mockMvc.perform(post("/api/events")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(eventDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Título").value("Test Event"))
                .andExpect(jsonPath("$.Descrição").value("Test description"))
                .andExpect(jsonPath("$.Local").value("Test Location"))
                .andReturn();

        // Verify the event was created
        String content = insertResult.getResponse().getContentAsString();
        EventDTO createdEvent = objectMapper.readValue(content, EventDTO.class);
        assertNotNull(createdEvent.getId());

        mockMvc.perform(get("/api/events/" + createdEvent.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ID").value(createdEvent.getId()))
                .andExpect(jsonPath("$.Título").value("Test Event"))
                .andExpect(jsonPath("$.Descrição").value("Test description"))
                .andExpect(jsonPath("$.Local").value("Test Location"))
                .andReturn();
    }
}