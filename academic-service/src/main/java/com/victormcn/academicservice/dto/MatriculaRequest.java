package com.victormcn.academicservice.dto;

public class MatriculaRequest {
    private String dataMatricula;
    private Long alunoId;
    private Long turmaId;

    public MatriculaRequest() {}

    public String getDataMatricula() { return dataMatricula; }
    public void setDataMatricula(String dataMatricula) { this.dataMatricula = dataMatricula; }
    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public Long getTurmaId() { return turmaId; }
    public void setTurmaId(Long turmaId) { this.turmaId = turmaId; }
}