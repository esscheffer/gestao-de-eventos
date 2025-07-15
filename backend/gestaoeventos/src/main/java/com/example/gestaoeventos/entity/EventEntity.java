package com.example.gestaoeventos.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.ZonedDateTime;

@Entity(name = "events")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@SQLDelete(sql = "UPDATE events SET deleted = true WHERE id = ?")
@SQLRestriction(value = "deleted = false")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private ZonedDateTime dateTime;

    private String location;

    @Builder.Default
    private boolean deleted = false;
}
