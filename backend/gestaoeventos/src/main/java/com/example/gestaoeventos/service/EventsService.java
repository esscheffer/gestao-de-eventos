package com.example.gestaoeventos.service;

import com.example.gestaoeventos.dto.EventDTO;
import com.example.gestaoeventos.exception.EventNotFoundException;
import com.example.gestaoeventos.mapper.EventMapper;
import com.example.gestaoeventos.repository.EventRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventsService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    public Page<EventDTO> getAllEvents(int page, int size) {
        return eventRepository.findAll(PageRequest.of(page, size)).map(eventMapper::toDto);
    }

    public EventDTO getEventById(Long id) {
        return eventRepository.findById(id)
                .map(eventMapper::toDto)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    public EventDTO createEvent(EventDTO eventDTO) {
        return eventMapper.toDto(eventRepository.save(eventMapper.toEntity(eventDTO)));
    }

    public EventDTO updateEvent(Long id, @Valid EventDTO eventDTO) {
        return eventRepository.findById(id)
                .map(event -> {
                    eventMapper.updateEventFromDto(eventDTO, event);
                    return eventMapper.toDto(eventRepository.save(event));
                })
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
