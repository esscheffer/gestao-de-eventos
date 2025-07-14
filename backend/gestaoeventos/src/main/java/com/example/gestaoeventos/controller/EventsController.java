package com.example.gestaoeventos.controller;

import com.example.gestaoeventos.dto.EventDTO;
import com.example.gestaoeventos.service.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventsController {

    private final EventsService eventService;

    @GetMapping("/api/events")
    public ResponseEntity<Page<EventDTO>> getAllEvents(@RequestParam int page,
                                                       @RequestParam int size) {
        return ResponseEntity.ok(eventService.getAllEvents(page, size));
    }
}
