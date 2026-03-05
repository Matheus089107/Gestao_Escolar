package com.castro.DTO.GestaoEscolar.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TurmaRequest (
        @NotBlank(message = "O nome da turma é obrigatório")
        String nome,
        @NotNull(message = "O ID do curso é obrigatório")
        Long cursoId,
        @NotNull(message = "O ID do professor é obrigatório")
        Long professorId,
        @NotEmpty(message = "A turma deve ter pelo menos um aluno")
        List<Long> listaAlunoIds
){}
