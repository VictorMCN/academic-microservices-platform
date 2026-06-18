package com.victormcn.academicservice.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String semestre;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany(
            mappedBy = "turma",
            cascade = CascadeType.ALL)
    private List<Matricula> matriculas =
            new ArrayList<>();

    @OneToMany(
            mappedBy = "turma",
            cascade = CascadeType.ALL)
    private List<Nota> notas =
            new ArrayList<>();

    @OneToMany(
            mappedBy = "turma",
            cascade = CascadeType.ALL)
    private List<Frequencia> frequencias =
            new ArrayList<>();

    public Turma() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSemestre() {
        return semestre;
    }

    public Curso getCurso() {
        return curso;
    }

    public Professor getProfessor() {
        return professor;
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

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
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