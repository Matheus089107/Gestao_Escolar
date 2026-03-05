package com.castro.DTO.GestaoEscolar.Mapper;

import com.castro.DTO.GestaoEscolar.dto.request.NotaRequest;
import com.castro.DTO.GestaoEscolar.dto.response.NotaResponse;
import com.castro.DTO.GestaoEscolar.model.Nota;

public class NotaMapper {
    public Nota toEntity(NotaRequest req){
        if(req.valor() < 0 || req.valor() > 10){
            throw new IllegalArgumentException("A nota deve estar entre 0 a 10");
        }
        return new Nota(null, req.alunoId(), req.aulaId(), req.valor());
    }

    public NotaResponse toResponse(Nota n, String alunoNome, String aulaAssunto){
        return new NotaResponse(n.getId(), alunoNome, aulaAssunto, n.getValor());
    }
}
