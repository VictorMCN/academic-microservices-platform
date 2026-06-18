package com.victormcn.academicservice.dto;

public class TurmaRequest {

    private String nome;
    private String semestre;

    private Long cursoId;
    private Long professorId;

    public TurmaRequest() {
    }

    public String getNome() {
        return nome;
    }

    public String getSemestre() {
        return semestre;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }
}