package com.castro.DTO.GestaoEscolar.service;

import com.castro.DTO.GestaoEscolar.dto.request.AulaRequest;
import com.castro.DTO.GestaoEscolar.dto.response.AulaResponse;
import com.castro.DTO.GestaoEscolar.model.Aula;
import com.castro.DTO.GestaoEscolar.repository.AulaRepository;
import com.castro.DTO.GestaoEscolar.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AulaService {

    private final AulaRepository aulaRepository;
    private final TurmaRepository turmaRepository;

    public AulaService(AulaRepository aulaRepository, TurmaRepository turmaRepository) {
        this.aulaRepository = aulaRepository;
        this.turmaRepository = turmaRepository;
    }

    public AulaResponse cadastrar(AulaRequest request) {
        var turma = turmaRepository.buscarPorId(request.turmaId());

        Aula aula = new Aula();
        aula.setTurmaId(request.turmaId());
        aula.setDataHora(request.dataHora());
        aula.setAssunto(request.assunto());

        Long idGerado = aulaRepository.salvar(aula);

        return new AulaResponse(idGerado, turma.getNome(), aula.getDataHora(), aula.getAssunto());
    }

    public List<AulaResponse> listarPorTurma(Long turmaId) {
        var turma = turmaRepository.buscarPorId(turmaId);

        return aulaRepository.buscarPorTurma(turmaId).stream()
                .map(aula -> new AulaResponse(
                        aula.getId(),
                        turma.getNome(),
                        aula.getDataHora(),
                        aula.getAssunto()
                ))
                .collect(Collectors.toList());
    }
}
