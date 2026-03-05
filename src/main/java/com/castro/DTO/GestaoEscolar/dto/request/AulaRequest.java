package com.castro.DTO.GestaoEscolar.dto.request;

import java.time.LocalDateTime;

public record AulaRequest (
        Long turmaId,
        LocalDateTime dataHora,
        String assunto
){
}
