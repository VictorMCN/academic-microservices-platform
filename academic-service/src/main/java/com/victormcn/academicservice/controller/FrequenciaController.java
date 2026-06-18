package com.victormcn.academicservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.victormcn.academicservice.dto.FrequenciaRequest;
import com.victormcn.academicservice.dto.FrequenciaResponse;
import com.victormcn.academicservice.service.FrequenciaService;

@RestController
@RequestMapping("/frequencias")
public class FrequenciaController {

    private final FrequenciaService frequenciaService;

    public FrequenciaController(
            FrequenciaService frequenciaService) {

        this.frequenciaService = frequenciaService;
    }

    @PostMapping
    public FrequenciaResponse criar(
            @RequestBody FrequenciaRequest request) {

        return frequenciaService.salvar(request);
    }

    @GetMapping
    public List<FrequenciaResponse> listarTodos() {

        return frequenciaService.listarTodos();
    }
}