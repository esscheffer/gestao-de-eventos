package com.example.gestaoeventos.controller;

import com.example.gestaoeventos.dto.EventDTO;
import com.example.gestaoeventos.service.EventsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EventsController {

    private final EventsService eventService;

    @GetMapping("/api/events")
    public ResponseEntity<Page<EventDTO>> getAllEvents(@RequestParam int page,
                                                       @RequestParam int size) {
        return ResponseEntity.ok(eventService.getAllEvents(page, size));
    }

    @GetMapping("/api/events/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @PostMapping("/api/events")
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.createEvent(eventDTO));
    }

    @PutMapping("/api/events/{id}")
    public ResponseEntity<EventDTO> createEvent(@PathVariable Long id,
                                                @Valid @RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.updateEvent(id, eventDTO));
    }
}
