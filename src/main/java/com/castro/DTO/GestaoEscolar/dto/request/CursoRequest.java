package com.castro.DTO.GestaoEscolar.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CursoRequest(
        @NotBlank(message = "O nome do curso é obrigatório")
        String nome,
        @NotBlank(message = "O código do curso é obrigatório")
        String codigo,
        @NotEmpty(message = "O curso deve ter pelo menos um professor associado")
        List<Long> listaProfessorIds) {
}
