package com.castro.DTO.GestaoEscolar.dto.response;

public record NotaResponse(
        Long id,
        String alunoNome,
        String aulaAssunto,
        Double valor
) {
}
