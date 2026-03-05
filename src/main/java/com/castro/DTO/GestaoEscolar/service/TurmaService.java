package com.castro.DTO.GestaoEscolar.service;

import com.castro.DTO.GestaoEscolar.Mapper.TurmaMapper;
import com.castro.DTO.GestaoEscolar.dto.request.TurmaRequest;
import com.castro.DTO.GestaoEscolar.dto.response.TurmaResponse;
import com.castro.DTO.GestaoEscolar.model.Turma;
import com.castro.DTO.GestaoEscolar.repository.AlunoRepository;
import com.castro.DTO.GestaoEscolar.repository.CursoRepository;
import com.castro.DTO.GestaoEscolar.repository.ProfessorRepository;
import com.castro.DTO.GestaoEscolar.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {
    private final TurmaRepository turmaRepository;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;
    private final TurmaMapper mapper;

    public TurmaService(TurmaRepository turmaRepository, AlunoRepository alunoRepository,
                        CursoRepository cursoRepository, ProfessorRepository professorRepository, TurmaMapper mapper) {
        this.turmaRepository = turmaRepository;
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
        this.professorRepository = professorRepository;
        this.mapper = mapper;
    }

    public TurmaResponse salvar(TurmaRequest request) {

        Turma turma = new Turma(null, request.nome(), request.cursoId(), request.professorId());
        Long idGerado = turmaRepository.salvar(turma);

        for (Long alunoId : request.listaAlunoIds()) {
            turmaRepository.vincularAluno(idGerado, alunoId);
        }

        return buscarDetalhesDaTurma(idGerado);
    }

    public TurmaResponse buscarDetalhesDaTurma(Long id) {
        Turma turma = turmaRepository.buscarPorId(id);
        String nomeCurso = cursoRepository.buscarPorId(turma.getCursoId()).getNome();
        String nomeProf = professorRepository.buscarPorId(turma.getProfessorId()).getNome();
        List<String> nomesAlunos = turmaRepository.buscarNomesAlunos(id);

        return mapper.toResponse(turma, nomeCurso, nomeProf, nomesAlunos);
    }
}