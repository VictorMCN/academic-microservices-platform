package com.victormcn.academicservice.dto;

public class TurmaRequest {
    private String nome;
    private String semestre;
    private Long cursoId;
    private Long professorId;

    public TurmaRequest() {}

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSemestre() { return semestre; }
    public void setSemestre(String semestre) { this.semestre = semestre; }
    public Long getCursoId() { return cursoId; }
    public void setCursoId(Long cursoId) { this.cursoId = cursoId; }
    public Long getProfessorId() { return professorId; }
    public void setProfessorId(Long professorId) { this.professorId = professorId; }
}