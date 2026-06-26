package com.victormcn.academicservice.dto;

import java.util.List;
import com.victormcn.academicservice.dto.MatriculaResponse;
import com.victormcn.academicservice.dto.NotaResponse;
import com.victormcn.academicservice.dto.FrequenciaResponse;

public class PerfilCompletoAlunoResponse {
    private Long alunoId;
    private List<MatriculaResponse> matriculas;
    private List<NotaResponse> notas;
    private List<FrequenciaResponse> frequencias;

    public PerfilCompletoAlunoResponse(Long alunoId, List<MatriculaResponse> matriculas, List<NotaResponse> notas, List<FrequenciaResponse> frequencias) {
        this.alunoId = alunoId;
        this.matriculas = matriculas;
        this.notas = notas;
        this.frequencias = frequencias;
    }

    public Long getAlunoId() { return alunoId; }
    public void setAlunoId(Long alunoId) { this.alunoId = alunoId; }
    public List<MatriculaResponse> getMatriculas() { return matriculas; }
    public void setMatriculas(List<MatriculaResponse> matriculas) { this.matriculas = matriculas; }
    public List<NotaResponse> getNotas() { return notas; }
    public void setNotas(List<NotaResponse> notas) { this.notas = notas; }
    public List<FrequenciaResponse> getFrequencias() { return frequencias; }
    public void setFrequencias(List<FrequenciaResponse> frequencias) { this.frequencias = frequencias; }
}