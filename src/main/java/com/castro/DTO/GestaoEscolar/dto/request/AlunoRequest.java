package com.castro.DTO.GestaoEscolar.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record AlunoRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 100)
        String nome,
        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Digite um e-mail valido")
        String email,
        @NotBlank(message = "Matricula é obrigatória")
        String matricula,
        @NotNull(message = "Data de nascimento é obrigatória")
        @Past(message = "A data de nascimento deve ser uma data passada")
        LocalDate dataNascimento
){}
