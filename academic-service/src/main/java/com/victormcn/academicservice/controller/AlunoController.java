package com.victormcn.academicservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.victormcn.academicservice.dto.AlunoRequest;
import com.victormcn.academicservice.dto.AlunoResponse;
import com.victormcn.academicservice.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(
            AlunoService alunoService) {

        this.alunoService = alunoService;
    }

    @PostMapping
    public AlunoResponse criar(
            @RequestBody AlunoRequest request) {

        return alunoService.salvar(request);
    }

    @GetMapping
    public List<AlunoResponse> listarTodos() {

        return alunoService.listarTodos();
    }
}