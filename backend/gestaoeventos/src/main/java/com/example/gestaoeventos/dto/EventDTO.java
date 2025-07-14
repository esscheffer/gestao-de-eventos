package com.example.gestaoeventos.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventDTO {

    @JsonProperty("ID")
    private Long id;
    @JsonProperty("Título")
    private String title;
    @JsonProperty("Descrição")
    private String description;
    @JsonProperty("Data e Hora")
    private ZonedDateTime dateTime;
    @JsonProperty("Local")
    private String location;
}
