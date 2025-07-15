package com.example.gestaoeventos.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EventDTO {

    @JsonProperty("ID")
    private Long id;

    @Size(max = 100, message = "Tamanho máximo do título de 100 caracteres excedido")
    @NotBlank(message = "Título é obrigatório")
    @JsonProperty("Título")
    private String title;

    @Size(max = 1000, message = "Tamanho máximo da descrição de 1000 caracteres excedido")
    @JsonProperty("Descrição")
    private String description;

    @NotNull(message = "Data e Hora é obrigatório")
    @JsonProperty("Data e Hora")
    private ZonedDateTime dateTime;

    @Size(max = 200, message = "Tamanho máximo do local de 200 caracteres excedido")
    @JsonProperty("Local")
    private String location;
}
