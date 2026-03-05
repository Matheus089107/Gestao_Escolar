package com.castro.DTO.GestaoEscolar.controller;

import com.castro.DTO.GestaoEscolar.dto.request.NotaRequest;
import com.castro.DTO.GestaoEscolar.dto.response.NotaResponse;
import com.castro.DTO.GestaoEscolar.service.NotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notas")
public class NotaController {
    private final NotaService service;

    public NotaController(NotaService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<NotaResponse> lancarNota(@RequestBody NotaRequest request) {

        return ResponseEntity.ok(service.registrarNota(request));
    }
}