package com.victormcn.academicservice.dto;

public class TurmaResponse {

    private Long id;

    private String nome;
    private String semestre;

    private Long cursoId;
    private Long professorId;

    public TurmaResponse(
            Long id,
            String nome,
            String semestre,
            Long cursoId,
            Long professorId) {

        this.id = id;
        this.nome = nome;
        this.semestre = semestre;
        this.cursoId = cursoId;
        this.professorId = professorId;
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

    public Long getCursoId() {
        return cursoId;
    }

    public Long getProfessorId() {
        return professorId;
    }
}