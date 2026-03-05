package com.castro.DTO.GestaoEscolar.Mapper;

import com.castro.DTO.GestaoEscolar.dto.response.TurmaResponse;
import com.castro.DTO.GestaoEscolar.model.Turma;

import java.util.List;

public class TurmaMapper {
    public TurmaResponse toResponse(Turma t, String nomeCurso, String nomeProf, List<String> alunos){
        return new TurmaResponse(t.getId(),t.getNome(), nomeCurso, nomeProf, alunos);
    }
}
