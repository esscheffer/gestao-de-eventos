package com.example.gestaoeventos.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldErrorDTO {
    private String campo;
    private String mensagem;
}
