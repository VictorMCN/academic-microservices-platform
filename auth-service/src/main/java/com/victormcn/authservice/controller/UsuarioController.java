package com.victormcn.authservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.victormcn.authservice.dto.UsuarioResponse;
import com.victormcn.authservice.model.Usuario;
import com.victormcn.authservice.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(
            UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioResponse> listarTodos() {

        return usuarioService.listarTodos()
                .stream()
                .map(this::converter)
                .toList();
    }

    private UsuarioResponse converter(
            Usuario usuario) {

        return new UsuarioResponse(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getRole());
    }
}