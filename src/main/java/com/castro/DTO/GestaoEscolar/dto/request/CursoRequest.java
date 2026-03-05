package com.castro.DTO.GestaoEscolar.dto.request;

import java.util.List;

public record CursoRequest(String nome, String codigo, List<Long> listaProfessorIds) {
}
