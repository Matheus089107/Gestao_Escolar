package com.castro.DTO.GestaoEscolar.controller;

import com.castro.DTO.GestaoEscolar.dto.request.ProfessorResquest;
import com.castro.DTO.GestaoEscolar.dto.response.ProfessorResponse;
import com.castro.DTO.GestaoEscolar.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService service;

    public ProfessorController(ProfessorService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<ProfessorResponse> criar(@RequestBody ProfessorResquest request) {
        return ResponseEntity.ok(service.salvar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}