package com.victormcn.academicservice.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @OneToMany(
            mappedBy = "aluno",
            cascade = CascadeType.ALL)
    private List<Matricula> matriculas =
            new ArrayList<>();

    @OneToMany(
            mappedBy = "aluno",
            cascade = CascadeType.ALL)
    private List<Nota> notas =
            new ArrayList<>();

    @OneToMany(
            mappedBy = "aluno",
            cascade = CascadeType.ALL)
    private List<Frequencia> frequencias =
            new ArrayList<>();

    public Aluno() {
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

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public List<Frequencia> getFrequencias() {
        return frequencias;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public void setFrequencias(List<Frequencia> frequencias) {
        this.frequencias = frequencias;
    }
}