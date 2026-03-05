package com.castro.DTO.GestaoEscolar.dto.response;

import java.time.LocalDate;

public record AlunoResponse (
        Long id,
        String nome,
        String email,
        String matricula,
        LocalDate dataNascimento
){}
