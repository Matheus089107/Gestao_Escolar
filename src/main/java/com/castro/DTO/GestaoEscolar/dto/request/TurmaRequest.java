package com.castro.DTO.GestaoEscolar.dto.request;

import java.util.List;

public record TurmaRequest (
        String nome,
        Long cursoId,
        Long professorId,
        List<Long> listaAlunoIds
){}
