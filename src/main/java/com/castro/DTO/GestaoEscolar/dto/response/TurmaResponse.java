package com.castro.DTO.GestaoEscolar.dto.response;

import java.util.List;

public record TurmaResponse (
        Long id,
        String nome,
        String nomeCurso,
        String nomeProfessor,
        List<String> listaAlunos
){
}
