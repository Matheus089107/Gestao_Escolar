package com.castro.DTO.GestaoEscolar.Mapper;

import com.castro.DTO.GestaoEscolar.dto.request.ProfessorResquest;
import com.castro.DTO.GestaoEscolar.dto.response.ProfessorResponse;
import com.castro.DTO.GestaoEscolar.model.Professor;

public class ProfessorMapper {
    public Professor toEntity(ProfessorResquest req){
        return new Professor(null, req.nome(), req.email(), req.disciplina());
    }
    public ProfessorResponse toResponse(Professor p){
        return new ProfessorResponse(p.getId(),p.getNome(),p.getEmail(),p.getDisciplina());
    }
}
