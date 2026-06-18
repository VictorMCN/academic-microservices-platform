package com.victormcn.academicservice.dto;

public class ProfessorRequest {

    private String nome;
    private String email;

    public ProfessorRequest() {
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}