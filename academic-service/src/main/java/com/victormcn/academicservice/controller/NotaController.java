package com.victormcn.academicservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.victormcn.academicservice.dto.NotaRequest;
import com.victormcn.academicservice.dto.NotaResponse;
import com.victormcn.academicservice.service.NotaService;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(
            NotaService notaService) {

        this.notaService = notaService;
    }

    @PostMapping
    public NotaResponse criar(
            @RequestBody NotaRequest request) {

        return notaService.salvar(request);
    }

    @GetMapping
    public List<NotaResponse> listarTodos() {

        return notaService.listarTodos();
    }
}