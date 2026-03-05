package com.castro.DTO.GestaoEscolar.Mapper;

import com.castro.DTO.GestaoEscolar.dto.response.AulaResponse;
import com.castro.DTO.GestaoEscolar.model.Aula;

public class AulaMapper {
    public AulaResponse toRespose(Aula aula, String nomeTurma){
        return new AulaResponse(aula.getId(), nomeTurma, aula.getDataHora(), aula.getAssunto());
    }
}
