package com.victormcn.authservice.dto;

import com.victormcn.authservice.model.Role;

public class UsuarioResponse {

    private Long id;
    private String username;
    private Role role;

    public UsuarioResponse() {
    }

    public UsuarioResponse(
            Long id,
            String username,
            Role role) {

        this.id = id;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}