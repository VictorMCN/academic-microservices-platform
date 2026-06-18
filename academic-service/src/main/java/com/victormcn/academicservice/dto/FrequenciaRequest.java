package com.victormcn.academicservice.dto;

public class FrequenciaRequest {

    private Integer faltas;

    private Long alunoId;
    private Long turmaId;

    public FrequenciaRequest() {
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

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }
}