package com.castro.DTO.GestaoEscolar.controller;

import com.castro.DTO.GestaoEscolar.dto.request.AulaRequest;
import com.castro.DTO.GestaoEscolar.dto.response.AulaResponse;
import com.castro.DTO.GestaoEscolar.service.AulaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aulas")
public class AulaController {
    private final AulaService service;

    public AulaController(AulaService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<AulaResponse> agendar(@RequestBody AulaRequest request) {
        return ResponseEntity.ok(service.cadastrar(request));
    }
}