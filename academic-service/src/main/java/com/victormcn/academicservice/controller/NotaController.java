package com.victormcn.academicservice.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.victormcn.academicservice.dto.NotaRequest;
import com.victormcn.academicservice.dto.NotaResponse;
import com.victormcn.academicservice.service.NotaService;
import com.victormcn.academicservice.repository.NotaRepository;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService notaService;
    private final NotaRepository notaRepository;

    public NotaController(NotaService notaService, NotaRepository notaRepository) {
        this.notaService = notaService;
        this.notaRepository = notaRepository;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR')")
    public ResponseEntity<NotaResponse> criar(@RequestBody NotaRequest request) {
        return ResponseEntity.ok(notaService.salvar(request));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR')")
    public ResponseEntity<List<NotaResponse>> listarTodas() {
        return ResponseEntity.ok(notaService.listarTodas());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR', 'ALUNO')")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return notaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR')")
    public ResponseEntity<NotaResponse> atualizar(@PathVariable Long id, @RequestBody NotaRequest request) {
        return ResponseEntity.ok(notaService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        notaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}