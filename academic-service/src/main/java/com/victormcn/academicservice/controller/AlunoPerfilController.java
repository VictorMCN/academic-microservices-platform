package com.victormcn.academicservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import com.victormcn.academicservice.dto.PerfilCompletoAlunoResponse;
import com.victormcn.academicservice.service.AlunoPerfilService;

@RestController
@RequestMapping("/aluno-perfil")
public class AlunoPerfilController {

    private final AlunoPerfilService alunoPerfilService;

    public AlunoPerfilController(AlunoPerfilService alunoPerfilService) {
        this.alunoPerfilService = alunoPerfilService;
    }

    @GetMapping("/{alunoId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR', 'ALUNO')")
    public ResponseEntity<PerfilCompletoAlunoResponse> obterPerfilCompleto(
            @PathVariable Long alunoId, 
            Authentication authentication) {
        
        String username = authentication.getName();
        
        // Extrai a role limpando o prefixo ROLE_ para o service tratar as regras
        String role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(r -> r.replace("ROLE_", ""))
                .findFirst()
                .orElse("ALUNO");

        return ResponseEntity.ok(alunoPerfilService.obterPerfilCompleto(alunoId, username, role));
    }
}