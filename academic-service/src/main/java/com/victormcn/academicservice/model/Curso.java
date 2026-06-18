package com.victormcn.academicservice.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @OneToMany(
            mappedBy = "curso",
            cascade = CascadeType.ALL)
    private List<Turma> turmas =
            new ArrayList<>();

    public Curso() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}