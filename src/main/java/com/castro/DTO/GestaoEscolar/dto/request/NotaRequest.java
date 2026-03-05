package com.castro.DTO.GestaoEscolar.dto.request;

public record NotaRequest(
        Long alunoId,
        Long aulaId,
        Double valor
) {
}
