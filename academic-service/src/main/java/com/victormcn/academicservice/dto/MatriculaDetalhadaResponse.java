package com.victormcn.academicservice.dto;

public class MatriculaDetalhadaResponse {
    private Long id;
    private String dataMatricula;
    private Long alunoId;
    private String nomeAluno; // Puxado dinamicamente do auth-service
    private Long turmaId;
    private String nomeTurma;

    public MatriculaDetalhadaResponse(Long id, String dataMatricula, Long alunoId, String nomeAluno, Long turmaId, String nomeTurma) {
        this.id = id;
        this.dataMatricula = dataMatricula;
        this.alunoId = alunoId;
        this.nomeAluno = nomeAluno;
        this.turmaId = turmaId;
        this.nomeTurma = nomeTurma;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDataMatricula() { return dataMatricula; }
    public void setDataMatricula(String dataMatricula) { this.dataMatricula = dataMatricula; }
    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public String getNomeAluno() { return nomeAluno; }
    public void setNomeAluno(String nomeAluno) { this.nomeAluno = nomeAluno; }
    public Long getTurmaId() { return turmaId; }
    public void setTurmaId(Long turmaId) { this.turmaId = turmaId; }
    public String getNomeTurma() { return nomeTurma; }
    public void setNomeTurma(String nomeTurma) { this.nomeTurma = nomeTurma; }
}