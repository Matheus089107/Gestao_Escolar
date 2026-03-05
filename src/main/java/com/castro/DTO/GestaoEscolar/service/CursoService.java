package com.castro.DTO.GestaoEscolar.service;

import com.castro.DTO.GestaoEscolar.Mapper.TurmaMapper;
import com.castro.DTO.GestaoEscolar.dto.request.CursoRequest;
import com.castro.DTO.GestaoEscolar.dto.response.CursoResponse;
import com.castro.DTO.GestaoEscolar.dto.response.TurmaResponse;
import com.castro.DTO.GestaoEscolar.model.Curso;
import com.castro.DTO.GestaoEscolar.repository.CursoRepository;
import com.castro.DTO.GestaoEscolar.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final TurmaRepository turmaRepository; // Injetado para resolver o erro da imagem
    private final TurmaMapper turmaMapper;

    // Construtor com todas as injeções necessárias
    public CursoService(CursoRepository cursoRepository,
                        TurmaRepository turmaRepository,
                        TurmaMapper turmaMapper) {
        this.cursoRepository = cursoRepository;
        this.turmaRepository = turmaRepository;
        this.turmaMapper = turmaMapper;
    }

    public CursoResponse salvar(CursoRequest request) {
        Curso curso = new Curso(null, request.nome(), request.codigo());

        Long cursoId = cursoRepository.salvar(curso);

        return new CursoResponse(cursoId, curso.getNome(), curso.getCodigo(), List.of());
    }

    public List<TurmaResponse> buscarTurmasPorCurso(Long cursoId) {
        return turmaRepository.listarPorCurso(cursoId).stream()
                .map(turma -> {
                    return turmaMapper.toResponse(turma, "Nome do Curso", "Nome do Professor", List.of());
                })
                .collect(Collectors.toList());
    }
}
