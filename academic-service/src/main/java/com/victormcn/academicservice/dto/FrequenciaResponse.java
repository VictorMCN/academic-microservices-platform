package com.victormcn.academicservice.dto;

public class FrequenciaResponse {

    private Long id;

    private Integer faltas;

    private Long alunoId;
    private Long turmaId;

    public FrequenciaResponse(
            Long id,
            Integer faltas,
            Long alunoId,
            Long turmaId) {

        this.id = id;
        this.faltas = faltas;
        this.alunoId = alunoId;
        this.turmaId = turmaId;
    }

    public Long getId() {
        return id;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public Long getTurmaId() {
        return turmaId;
    }
}