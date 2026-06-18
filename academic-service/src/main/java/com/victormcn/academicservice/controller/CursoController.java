package com.victormcn.academicservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.victormcn.academicservice.dto.CursoRequest;
import com.victormcn.academicservice.dto.CursoResponse;
import com.victormcn.academicservice.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(
            CursoService cursoService) {

        this.cursoService = cursoService;
    }

    @PostMapping
    public CursoResponse criar(
            @RequestBody CursoRequest request) {

        return cursoService.salvar(request);
    }

    @GetMapping
    public List<CursoResponse> listarTodos() {

        return cursoService.listarTodos();
    }
}