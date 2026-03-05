package com.castro.DTO.GestaoEscolar.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AulaRequest (
        @NotNull(message ="O ID da turma é obrigatório")
        Long turmaId,
        @NotNull(message = "A data e hora da aula são obrigatorias")
        LocalDateTime dataHora,
        @NotBlank(message = "O assunto da aula não pode estar vazio")
        @Size(min = 5, max = 100, message = "O assunto deve ter entre 5 a 100 caracteres")
        String assunto
){
}
