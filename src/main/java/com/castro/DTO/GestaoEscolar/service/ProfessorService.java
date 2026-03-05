package com.castro.DTO.GestaoEscolar.service;

import com.castro.DTO.GestaoEscolar.Mapper.ProfessorMapper;
import com.castro.DTO.GestaoEscolar.dto.request.ProfessorResquest;
import com.castro.DTO.GestaoEscolar.dto.response.ProfessorResponse;
import com.castro.DTO.GestaoEscolar.model.Professor;
import com.castro.DTO.GestaoEscolar.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    private final ProfessorRepository repository;
    private final ProfessorMapper mapper;

    public ProfessorService(ProfessorRepository repository, ProfessorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProfessorResponse salvar(ProfessorResquest request) {
        Professor p = mapper.toEntity(request);
        repository.salvar(p);
        return mapper.toResponse(p);
    }
    public ProfessorResponse buscarPorId(Long id) {
        Professor p = repository.buscarPorId(id);
        return mapper.toResponse(p);
    }
}