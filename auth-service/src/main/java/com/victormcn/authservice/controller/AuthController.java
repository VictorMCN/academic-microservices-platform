package com.victormcn.authservice.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.victormcn.authservice.config.JwtUtil;
import com.victormcn.authservice.dto.LoginRequest;
import com.victormcn.authservice.dto.LoginResponse;
import com.victormcn.authservice.model.Usuario;
import com.victormcn.authservice.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthController(
            UsuarioService usuarioService,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {

        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/teste")
    public String teste() {
        return "AUTH LIBERADO";
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        Usuario usuario = usuarioService
                .buscarPorUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        boolean senhaCorreta = passwordEncoder.matches(
                request.getPassword(),
                usuario.getPassword());

        if (!senhaCorreta) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtUtil.gerarToken(usuario.getUsername());

        return new LoginResponse(token);
    }
}