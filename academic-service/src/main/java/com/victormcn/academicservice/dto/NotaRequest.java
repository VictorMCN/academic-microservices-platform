package com.victormcn.academicservice.dto;

public class NotaRequest {
    private Double valor;
    private Long alunoId;
    private Long turmaId;

    public NotaRequest() {}

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public Long getTurmaId() { return turmaId; }
    public void setTurmaId(Long turmaId) { this.turmaId = turmaId; }
}