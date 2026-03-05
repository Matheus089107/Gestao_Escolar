package com.castro.DTO.GestaoEscolar.Mapper;

import com.castro.DTO.GestaoEscolar.dto.request.AlunoRequest;
import com.castro.DTO.GestaoEscolar.dto.response.AlunoResponse;
import com.castro.DTO.GestaoEscolar.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    public Aluno toEntity(AlunoRequest req){
        return new Aluno(null, req.nome(), req.email(), req.matricula(), req.dataNascimento());
    }
    public AlunoResponse toResponse(Aluno a){
        return new AlunoResponse(a.getId(),a.getNome(),a.getEmail(),a.getMatricula(),a.getDataNascimento());
    }
}
