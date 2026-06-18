package com.victormcn.academicservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.victormcn.academicservice.dto.ProfessorRequest;
import com.victormcn.academicservice.dto.ProfessorResponse;
import com.victormcn.academicservice.service.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(
            ProfessorService professorService) {

        this.professorService = professorService;
    }

    @PostMapping
    public ProfessorResponse criar(
            @RequestBody ProfessorRequest request) {

        return professorService.salvar(request);
    }

    @GetMapping
    public List<ProfessorResponse> listarTodos() {

        return professorService.listarTodos();
    }
}