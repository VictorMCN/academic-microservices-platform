package com.victormcn.academicservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios-academic")
public class UsuarioAcademicController {

    @GetMapping("/status")
    public ResponseEntity<String> obterStatus(@RequestHeader("X-User-Roles") String roles) {
        return ResponseEntity.ok("Servico academico ativo. Papeis detectados: " + roles);
    }
}