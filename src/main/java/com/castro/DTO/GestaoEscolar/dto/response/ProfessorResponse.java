package com.castro.DTO.GestaoEscolar.dto.response;

public record ProfessorResponse (
        Long id,
        String nome,
        String email,
        String disciplina
) {}
