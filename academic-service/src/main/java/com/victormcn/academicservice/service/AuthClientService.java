package com.victormcn.academicservice.service;

import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.victormcn.academicservice.dto.UsuarioResponse;

@Service
public class AuthClientService {

    private final WebClient webClient;

    public AuthClientService(WebClient authWebClient) {
        this.webClient = authWebClient;
    }

    private String obterTokenAtual() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.getCredentials() != null) {
            return auth.getCredentials().toString();
        }
        return null;
    }

    public UsuarioResponse buscarPorId(Long id) {
        String token = obterTokenAtual();
        return webClient.get()
                .uri("/usuarios/{id}", id)
                .headers(h -> { if (token != null) h.setBearerAuth(token); })
                .retrieve()
                .bodyToMono(UsuarioResponse.class)
                .block();
    }

    public UsuarioResponse buscarUsuarioPorId(Long id) {
        return buscarPorId(id);
    }

    public List<UsuarioResponse> listarUsuarios() {
        String token = obterTokenAtual();
        return webClient.get()
                .uri("/usuarios")
                .headers(h -> { if (token != null) h.setBearerAuth(token); })
                .retrieve()
                .bodyToFlux(UsuarioResponse.class)
                .collectList()
                .block();
    }

    public List<UsuarioResponse> listarPorRole(String role) {
        String token = obterTokenAtual();
        return webClient.get()
                .uri("/usuarios/role/{roleName}", role)
                .headers(h -> { if (token != null) h.setBearerAuth(token); })
                .retrieve()
                .bodyToFlux(UsuarioResponse.class)
                .collectList()
                .block();
    }
}