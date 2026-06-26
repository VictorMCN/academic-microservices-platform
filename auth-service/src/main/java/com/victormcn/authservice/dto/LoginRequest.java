package com.victormcn.authservice.dto;

public class LoginRequest {
    private String nome;
    private String senha;
    private String role;

    public LoginRequest() {}

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}