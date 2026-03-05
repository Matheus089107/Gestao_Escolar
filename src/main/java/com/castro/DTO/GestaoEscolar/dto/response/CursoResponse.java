package com.castro.DTO.GestaoEscolar.dto.response;

import java.util.List;

public record CursoResponse(
        Long id,
        String nome,
        String codigo,
        List<String> listaProfessores
) {
}
