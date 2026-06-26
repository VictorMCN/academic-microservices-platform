package com.victormcn.academicservice.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.victormcn.academicservice.dto.FrequenciaRequest;
import com.victormcn.academicservice.dto.FrequenciaResponse;
import com.victormcn.academicservice.model.Frequencia;
import com.victormcn.academicservice.repository.FrequenciaRepository;

@Service
public class FrequenciaService {

    private final FrequenciaRepository frequenciaRepository;

    public FrequenciaService(FrequenciaRepository frequenciaRepository) {
        this.frequenciaRepository = frequenciaRepository;
    }

    public FrequenciaResponse salvar(FrequenciaRequest request) {
        Frequencia frequencia = new Frequencia();
        frequencia.setFaltas(request.getFaltas());
        frequencia.setAlunoId(request.getAlunoId());
        frequencia.setTurmaId(request.getTurmaId());
        
        Frequencia salva = frequenciaRepository.save(frequencia);
        return new FrequenciaResponse(salva.getId(), salva.getFaltas(), salva.getAlunoId(), salva.getTurmaId());
    }

    public List<FrequenciaResponse> listarTodas() {
        return frequenciaRepository.findAll().stream()
                .map(f -> new FrequenciaResponse(f.getId(), f.getFaltas(), f.getAlunoId(), f.getTurmaId()))
                .collect(Collectors.toList());
    }

    public List<FrequenciaResponse> buscarPorAluno(Long alunoId) {
        return frequenciaRepository.findByAlunoId(alunoId).stream()
                .map(f -> new FrequenciaResponse(f.getId(), f.getFaltas(), f.getAlunoId(), f.getTurmaId()))
                .collect(Collectors.toList());
    }

    public FrequenciaResponse atualizar(Long id, FrequenciaRequest request) {
        Frequencia frequencia = frequenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Frequencia nao encontrada com o ID: " + id));
        
        frequencia.setFaltas(request.getFaltas());
        frequencia.setAlunoId(request.getAlunoId());
        frequencia.setTurmaId(request.getTurmaId());
        
        Frequencia atualizada = frequenciaRepository.save(frequencia);
        return new FrequenciaResponse(atualizada.getId(), atualizada.getFaltas(), atualizada.getAlunoId(), atualizada.getTurmaId());
    }

    public void deletar(Long id) {
        if (!frequenciaRepository.existsById(id)) {
            throw new RuntimeException("Frequencia nao encontrada com o ID: " + id);
        }
        frequenciaRepository.deleteById(id);
    }
}