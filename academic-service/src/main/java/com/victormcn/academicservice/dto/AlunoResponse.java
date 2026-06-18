package com.victormcn.academicservice.dto;

public class AlunoResponse {

    private Long id;
    private String nome;
    private String email;

    public AlunoResponse(
            Long id,
            String nome,
            String email) {

        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}