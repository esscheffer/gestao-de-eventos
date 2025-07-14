package com.example.gestaoeventos.exception;

import lombok.Getter;

@Getter
public class EventNotFoundException extends RuntimeException {
    private Long eventId;

    public EventNotFoundException(Long eventId) {
        this.eventId = eventId;
    }
}
