package com.victormcn.academicservice.dto;

public class CursoRequest {

    private String nome;

    private String descricao;

    public CursoRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}