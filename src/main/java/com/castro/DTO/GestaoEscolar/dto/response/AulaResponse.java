package com.castro.DTO.GestaoEscolar.dto.response;

import java.time.LocalDateTime;

public record AulaResponse(
        Long id,
        String nomeTurma,
        LocalDateTime dataHora,
        String assunto
) {
}
