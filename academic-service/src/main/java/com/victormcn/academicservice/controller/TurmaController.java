package com.victormcn.academicservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.victormcn.academicservice.dto.TurmaRequest;
import com.victormcn.academicservice.dto.TurmaResponse;
import com.victormcn.academicservice.service.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController(
            TurmaService turmaService) {

        this.turmaService = turmaService;
    }

    @PostMapping
    public TurmaResponse criar(
            @RequestBody TurmaRequest request) {

        return turmaService.salvar(request);
    }

    @GetMapping
    public List<TurmaResponse> listarTodos() {

        return turmaService.listarTodos();
    }
}