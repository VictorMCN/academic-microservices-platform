package com.victormcn.academicservice.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.victormcn.academicservice.dto.MatriculaRequest;
import com.victormcn.academicservice.dto.MatriculaResponse;
import com.victormcn.academicservice.service.MatriculaService;
import com.victormcn.academicservice.repository.MatriculaRepository;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final MatriculaRepository matriculaRepository;

    public MatriculaController(MatriculaService matriculaService, MatriculaRepository matriculaRepository) {
        this.matriculaService = matriculaService;
        this.matriculaRepository = matriculaRepository;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MatriculaResponse> criar(@RequestBody MatriculaRequest request) {
        return ResponseEntity.ok(matriculaService.salvar(request));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR')")
    public ResponseEntity<List<MatriculaResponse>> listarTodas() {
        return ResponseEntity.ok(matriculaService.listarTodas());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR', 'ALUNO')")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return matriculaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MatriculaResponse> atualizar(@PathVariable Long id, @RequestBody MatriculaRequest request) {
        return ResponseEntity.ok(matriculaService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        matriculaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}