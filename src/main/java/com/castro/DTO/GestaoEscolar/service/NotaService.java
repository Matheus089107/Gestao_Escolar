package com.castro.DTO.GestaoEscolar.service;

import com.castro.DTO.GestaoEscolar.Mapper.NotaMapper;
import com.castro.DTO.GestaoEscolar.dto.request.NotaRequest;
import com.castro.DTO.GestaoEscolar.dto.response.NotaResponse;
import com.castro.DTO.GestaoEscolar.model.Nota;
import com.castro.DTO.GestaoEscolar.repository.AlunoRepository;
import com.castro.DTO.GestaoEscolar.repository.AulaRepository;
import com.castro.DTO.GestaoEscolar.repository.NotaRepository;
import org.springframework.stereotype.Service;

@Service
public class NotaService {
    private final NotaRepository notaRepository;
    private final AlunoRepository alunoRepository;
    private final AulaRepository aulaRepository;
    private final NotaMapper mapper;

    public NotaService(NotaRepository notaRepository, AlunoRepository alunoRepository,
                       AulaRepository aulaRepository, NotaMapper mapper) {
        this.notaRepository = notaRepository;
        this.alunoRepository = alunoRepository;
        this.aulaRepository = aulaRepository;
        this.mapper = mapper;
    }

    public NotaResponse registrarNota(NotaRequest request) {

        if (request.valor() < 0 || request.valor() > 10) {
            throw new IllegalArgumentException("Valor da nota inválido (0-10)");
        }

        Nota nota = mapper.toEntity(request);
        notaRepository.salvar(nota);

        String nomeAluno = alunoRepository.buscarPorId(request.alunoId()).getNome();
        String assuntoAula = aulaRepository.buscarPorId(request.aulaId()).getAssunto();

        return mapper.toResponse(nota, nomeAluno, assuntoAula);
    }
}