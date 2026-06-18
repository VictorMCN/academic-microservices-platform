package com.victormcn.academicservice.dto;

public class NotaRequest {

    private Double valor;

    private Long alunoId;
    private Long turmaId;

    public NotaRequest() {
    }

    public Double getValor() {
        return valor;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public Long getTurmaId() {
        return turmaId;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }
}