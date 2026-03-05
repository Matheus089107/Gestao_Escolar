package com.castro.DTO.GestaoEscolar.controller;

import com.castro.DTO.GestaoEscolar.dto.request.CursoRequest;
import com.castro.DTO.GestaoEscolar.dto.response.CursoResponse;
import com.castro.DTO.GestaoEscolar.dto.response.TurmaResponse;
import com.castro.DTO.GestaoEscolar.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService service;

    public CursoController(CursoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<CursoResponse> criar(@Valid @RequestBody CursoRequest request) {
        return ResponseEntity.ok(service.salvar(request));
    }

    @GetMapping("/{id}/turmas")
    public ResponseEntity<List<TurmaResponse>> listarTurmas(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarTurmasPorCurso(id));
    }
}