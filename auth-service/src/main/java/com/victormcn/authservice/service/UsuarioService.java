package com.victormcn.authservice.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.victormcn.authservice.dto.RegisterRequest;
import com.victormcn.authservice.dto.RegisterResponse;
import com.victormcn.authservice.dto.LoginRequest;
import com.victormcn.authservice.dto.UsuarioResponse;
import com.victormcn.authservice.model.Usuario;
import com.victormcn.authservice.model.Role;
import com.victormcn.authservice.repository.UsuarioRepository;
import com.victormcn.authservice.config.JwtUtil;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public RegisterResponse registrar(RegisterRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        
        if (request.getRole() != null) {
            String roleStr = request.getRole().toUpperCase();
            if (!roleStr.startsWith("ROLE_")) {
                roleStr = "ROLE_" + roleStr;
            }
            usuario.setRole(Role.valueOf(roleStr));
        } else {
            usuario.setRole(Role.ROLE_ALUNO);
        }
        
        usuarioRepository.save(usuario);
        
    
        return new RegisterResponse();
    }

    public String login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByNome(request.getNome())
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        if (!passwordEncoder.matches(request.getSenha(), usuario.getSenha())) {
            throw new RuntimeException("Senha invalida");
        }

        String roleName = (usuario.getRole() != null) ? usuario.getRole().name() : "ROLE_ALUNO";
        return jwtUtil.gerarToken(usuario.getNome(), roleName);
    }

    public List<UsuarioResponse> listarTodos() {
        return usuarioRepository.findAll().stream().map(u -> {
            UsuarioResponse res = new UsuarioResponse();
            res.setId(u.getId());
            res.setNome(u.getNome());
            res.setRole(u.getRole() != null ? u.getRole().name() : "ROLE_ALUNO");
            return res;
        }).collect(Collectors.toList());
    }

    public UsuarioResponse buscarPorId(Long id) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        UsuarioResponse res = new UsuarioResponse();
        res.setId(u.getId());
        res.setNome(u.getNome());
        res.setRole(u.getRole() != null ? u.getRole().name() : "ROLE_ALUNO");
        return res;
    }

    public List<UsuarioResponse> listarPorRole(String role) {
        String roleStr = role.toUpperCase();
        if (!roleStr.startsWith("ROLE_")) {
            roleStr = "ROLE_" + roleStr;
        }
        Role roleEnum = Role.valueOf(roleStr);
        return usuarioRepository.findAll().stream()
                .filter(u -> u.getRole() == roleEnum)
                .map(u -> {
                    UsuarioResponse res = new UsuarioResponse();
                    res.setId(u.getId());
                    res.setNome(u.getNome());
                    res.setRole(u.getRole().name());
                    return res;
                }).collect(Collectors.toList());
    }

    public UsuarioResponse atualizar(Long id, RegisterRequest request) {
        Usuario u = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        
        u.setNome(request.getNome());
        if (request.getSenha() != null && !request.getSenha().isEmpty()) {
            u.setSenha(passwordEncoder.encode(request.getSenha()));
        }
        if (request.getRole() != null) {
            String roleStr = request.getRole().toUpperCase();
            if (!roleStr.startsWith("ROLE_")) {
                roleStr = "ROLE_" + roleStr;
            }
            u.setRole(Role.valueOf(roleStr));
        }
        
        Usuario atualizado = usuarioRepository.save(u);
        UsuarioResponse res = new UsuarioResponse();
        res.setId(atualizado.getId());
        res.setNome(atualizado.getNome());
        res.setRole(atualizado.getRole() != null ? atualizado.getRole().name() : "ROLE_ALUNO");
        return res;
    }

    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario nao encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}