package com.victormcn.academicservice.dto;

public class MatriculaResponse {

    private Long id;

    private String dataMatricula;

    private Long alunoId;
    private Long turmaId;

    public MatriculaResponse(
            Long id,
            String dataMatricula,
            Long alunoId,
            Long turmaId) {

        this.id = id;
        this.dataMatricula = dataMatricula;
        this.alunoId = alunoId;
        this.turmaId = turmaId;
    }

    public Long getId() {
        return id;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public Long getTurmaId() {
        return turmaId;
    }
}