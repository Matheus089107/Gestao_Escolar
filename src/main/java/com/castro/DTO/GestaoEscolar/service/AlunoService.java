package com.castro.DTO.GestaoEscolar.service;

import com.castro.DTO.GestaoEscolar.Mapper.AlunoMapper;
import com.castro.DTO.GestaoEscolar.Mapper.NotaMapper;
import com.castro.DTO.GestaoEscolar.dto.request.AlunoRequest;
import com.castro.DTO.GestaoEscolar.dto.response.AlunoResponse;
import com.castro.DTO.GestaoEscolar.dto.response.NotaResponse;
import com.castro.DTO.GestaoEscolar.model.Aluno;
import com.castro.DTO.GestaoEscolar.model.Nota;
import com.castro.DTO.GestaoEscolar.repository.AlunoRepository;
import com.castro.DTO.GestaoEscolar.repository.AulaRepository;
import com.castro.DTO.GestaoEscolar.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final NotaRepository notaRepository;
    private final AulaRepository aulaRepository;
    private final AlunoMapper alunoMapper;
    private final NotaMapper notaMapper;

    public AlunoService(AlunoRepository alunoRepository,
                        NotaRepository notaRepository,
                        AulaRepository aulaRepository,
                        AlunoMapper alunoMapper,
                        NotaMapper notaMapper) {
        this.alunoRepository = alunoRepository;
        this.notaRepository = notaRepository;
        this.aulaRepository = aulaRepository;
        this.alunoMapper = alunoMapper;
        this.notaMapper = notaMapper;
    }

    public AlunoResponse cadastrar(AlunoRequest request) {
        if (!request.email().contains("@")) {
            throw new RuntimeException("Email inválido");
        }
        Aluno aluno = alunoMapper.toEntity(request);
        alunoRepository.salvar(aluno);
        return alunoMapper.toResponse(aluno);
    }

    public AlunoResponse buscarPorId(Long id) {
        Aluno aluno = alunoRepository.buscarPorId(id);
        return alunoMapper.toResponse(aluno);
    }

    public List<NotaResponse> getNotasByAluno(Long alunoId) {
        List<Nota> notas = notaRepository.getNotasByAluno(alunoId);

        return notas.stream()
                .map(nota -> {
                    String assunto = aulaRepository.buscarPorId(nota.getAulaId()).getAssunto();
                    return notaMapper.toResponse(nota, "Nome do Aluno", assunto);
                })
                .collect(Collectors.toList());
    }

    public void deletar(Long id) {
        alunoRepository.deletar(id);
    }

    public List<AlunoResponse> listarTodos() {
        return alunoRepository.listarTodos().stream()
                .map(alunoMapper::toResponse)
                .collect(Collectors.toList());
    }
}