package com.castro.DTO.GestaoEscolar.controller;

import com.castro.DTO.GestaoEscolar.dto.request.TurmaRequest;
import com.castro.DTO.GestaoEscolar.dto.response.TurmaResponse;
import com.castro.DTO.GestaoEscolar.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    private final TurmaService service;

    public TurmaController(TurmaService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<TurmaResponse> criar(@Valid @RequestBody TurmaRequest request) {
        return ResponseEntity.ok(service.salvar(request));
    }

    @GetMapping("/{id}/alunos")
    public ResponseEntity<TurmaResponse> buscarAlunosDaTurma(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarDetalhesDaTurma(id));
    }
}