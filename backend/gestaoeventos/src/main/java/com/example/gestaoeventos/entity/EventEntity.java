package com.example.gestaoeventos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Entity(name = "events")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private ZonedDateTime dateTime;

    private String location;
}
