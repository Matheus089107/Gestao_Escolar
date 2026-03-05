package com.castro.DTO.GestaoEscolar.dto.request;

import java.time.LocalDate;

public record AlunoRequest(
        String nome,
        String email,
        String matricula,
        LocalDate dataNascimento
){}
