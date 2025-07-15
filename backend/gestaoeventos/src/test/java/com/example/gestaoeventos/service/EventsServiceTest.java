package com.example.gestaoeventos.service;

import com.example.gestaoeventos.dto.EventDTO;
import com.example.gestaoeventos.entity.EventEntity;
import com.example.gestaoeventos.exception.EventNotFoundException;
import com.example.gestaoeventos.mapper.EventMapper;
import com.example.gestaoeventos.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventsServiceTest {

    @Mock
    private EventRepository eventRepository;

    @Mock
    private EventMapper eventMapper;

    @InjectMocks
    private EventsService eventsService;

    private EventDTO testEventDTO;
    private EventEntity testEventEntity;

    @BeforeEach
    void setUp() {
        testEventDTO = EventDTO.builder()
                .title("Test Event")
                .description("Test description")
                .dateTime(ZonedDateTime.now())
                .location("Test Location")
                .build();

        testEventEntity = EventEntity.builder()
                .id(1L)
                .title(testEventDTO.getTitle())
                .description(testEventDTO.getDescription())
                .dateTime(testEventDTO.getDateTime())
                .location(testEventDTO.getLocation())
                .build();
    }

    @Test
    void getAllEvents_ShouldReturnEvents() {
        // given
        Page<EventEntity> page = new PageImpl<>(Collections.singletonList(testEventEntity));
        Page<EventDTO> expectedPage = new PageImpl<>(Collections.singletonList(testEventDTO));

        when(eventRepository.findAll(any(PageRequest.class))).thenReturn(page);
        when(eventMapper.toDto(testEventEntity)).thenReturn(testEventDTO);

        // when
        Page<EventDTO> result = eventsService.getAllEvents(0, 10);

        // then
        assertEquals(expectedPage, result);
        verify(eventRepository).findAll(any(PageRequest.class));
        verify(eventMapper).toDto(testEventEntity);
    }

    @Test
    void getEventById_ShouldReturnEvent() {
        // given
        when(eventRepository.findById(1L)).thenReturn(Optional.of(testEventEntity));
        when(eventMapper.toDto(testEventEntity)).thenReturn(testEventDTO);

        // when
        EventDTO result = eventsService.getEventById(1L);

        // then
        assertEquals(testEventDTO, result);
        verify(eventRepository).findById(1L);
        verify(eventMapper).toDto(testEventEntity);
    }

    @Test
    void getEventById_ShouldThrowEventNotFoundException() {
        // Arrange
        when(eventRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EventNotFoundException.class, () -> eventsService.getEventById(1L));
        verify(eventRepository).findById(1L);
        verify(eventMapper, never()).toDto(any());
    }

    @Test
    void createEvent_ShouldCreateEvent() {
        // Arrange
        when(eventMapper.toEntity(testEventDTO)).thenReturn(testEventEntity);
        when(eventRepository.save(testEventEntity)).thenReturn(testEventEntity);
        when(eventMapper.toDto(testEventEntity)).thenReturn(testEventDTO);

        // Act
        EventDTO result = eventsService.createEvent(testEventDTO);

        // Assert
        assertEquals(testEventDTO, result);
        verify(eventMapper).toEntity(testEventDTO);
        verify(eventRepository).save(testEventEntity);
        verify(eventMapper).toDto(testEventEntity);
    }
}