package com.castro.DTO.GestaoEscolar.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProfessorResquest (
        @NotBlank(message = "O nome não pode estar em branco")
        @Size(min = 3, max = 50, message = "O nome teve ter entre 3 a 50 caracteres")
        String nome,
        @Email(message = "Email digitado de forma incorreta")
        @NotBlank(message = "O e-mail é obrigatorio")
        String email,
        @NotBlank(message = "A disciplina é obrigatória")
        String disciplina
) {}
