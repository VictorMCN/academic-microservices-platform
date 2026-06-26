package com.victormcn.academicservice.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.victormcn.academicservice.dto.FrequenciaRequest;
import com.victormcn.academicservice.dto.FrequenciaResponse;
import com.victormcn.academicservice.service.FrequenciaService;
import com.victormcn.academicservice.repository.FrequenciaRepository;

@RestController
@RequestMapping("/frequencias")
public class FrequenciaController {

    private final FrequenciaService frequenciaService;
    private final FrequenciaRepository frequenciaRepository;

    public FrequenciaController(FrequenciaService frequenciaService, FrequenciaRepository frequenciaRepository) {
        this.frequenciaService = frequenciaService;
        this.frequenciaRepository = frequenciaRepository;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR')")
    public ResponseEntity<FrequenciaResponse> criar(@RequestBody FrequenciaRequest request) {
        return ResponseEntity.ok(frequenciaService.salvar(request));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR')")
    public ResponseEntity<List<FrequenciaResponse>> listarTodas() {
        return ResponseEntity.ok(frequenciaService.listarTodas());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR', 'ALUNO')")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        return frequenciaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR')")
    public ResponseEntity<FrequenciaResponse> atualizar(@PathVariable Long id, @RequestBody FrequenciaRequest request) {
        return ResponseEntity.ok(frequenciaService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        frequenciaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}