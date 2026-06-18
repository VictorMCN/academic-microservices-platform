package com.victormcn.academicservice.dto;

public class NotaResponse {

    private Long id;

    private Double valor;

    private Long alunoId;
    private Long turmaId;

    public NotaResponse(
            Long id,
            Double valor,
            Long alunoId,
            Long turmaId) {

        this.id = id;
        this.valor = valor;
        this.alunoId = alunoId;
        this.turmaId = turmaId;
    }

    public Long getId() {
        return id;
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
}