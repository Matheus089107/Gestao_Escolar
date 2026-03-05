package com.castro.DTO.GestaoEscolar.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record NotaRequest(
        @NotNull(message = "ID do aluno é obrigatório")
        Long alunoId,
        @NotNull(message = "ID da aula é obrigatório")
        Long aulaId,
        @NotNull(message = "O valor da nota é obrigatório")
        @Min(value = 0, message = "A nota minima é 0")
        @Max(value = 10, message = "A nota maxima é 10")
        Double valor
) {
}
