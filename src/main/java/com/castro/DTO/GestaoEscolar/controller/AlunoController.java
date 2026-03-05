package com.castro.DTO.GestaoEscolar.controller;
import com.castro.DTO.GestaoEscolar.dto.request.AlunoRequest;
import com.castro.DTO.GestaoEscolar.dto.response.AlunoResponse;
import com.castro.DTO.GestaoEscolar.dto.response.NotaResponse;
import com.castro.DTO.GestaoEscolar.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> cadastrar(@Valid @RequestBody AlunoRequest request) {
        return ResponseEntity.ok(alunoService.cadastrar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.buscarPorId(id));
    }

    @GetMapping("/{id}/notas")
    public ResponseEntity<List<NotaResponse>> listarNotas(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.getNotasByAluno(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
