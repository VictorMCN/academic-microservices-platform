package com.victormcn.academicservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.victormcn.academicservice.dto.MatriculaRequest;
import com.victormcn.academicservice.dto.MatriculaResponse;
import com.victormcn.academicservice.service.MatriculaService;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(
            MatriculaService matriculaService) {

        this.matriculaService = matriculaService;
    }

    @PostMapping
    public MatriculaResponse criar(
            @RequestBody MatriculaRequest request) {

        return matriculaService.salvar(request);
    }

    @GetMapping
    public List<MatriculaResponse> listarTodos() {

        return matriculaService.listarTodos();
    }
}