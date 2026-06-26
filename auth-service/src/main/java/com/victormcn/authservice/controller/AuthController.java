package com.victormcn.authservice.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.victormcn.authservice.config.JwtUtil;
import com.victormcn.authservice.dto.*;
import com.victormcn.authservice.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UsuarioService usuarioService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UsuarioService usuarioService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public RegisterResponse registrar(@RequestBody RegisterRequest request) {
        return usuarioService.registrar(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getNome(), request.getSenha())
        );
        String role = usuarioService.listarTodos().stream()
                .filter(u -> u.getNome().equals(request.getNome()))
                .findFirst()
                .map(UsuarioResponse::getRole)
                .orElse("ALUNO");
        String token = jwtUtil.gerarToken(request.getNome(), role);
        return new LoginResponse(token);
    }
}