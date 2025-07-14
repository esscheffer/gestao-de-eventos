package com.example.gestaoeventos.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponseDTO {
    private int status;
    private String error;
    private String message;
    private List<FieldErrorDTO> fieldErrors;
}
