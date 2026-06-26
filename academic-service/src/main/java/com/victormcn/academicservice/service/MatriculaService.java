package com.victormcn.academicservice.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.victormcn.academicservice.dto.MatriculaRequest;
import com.victormcn.academicservice.dto.MatriculaResponse;
import com.victormcn.academicservice.model.Matricula;
import com.victormcn.academicservice.repository.MatriculaRepository;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public MatriculaResponse salvar(MatriculaRequest request) {
        Matricula matricula = new Matricula();
        matricula.setDataMatricula(request.getDataMatricula());
        matricula.setAlunoId(request.getAlunoId());
        matricula.setTurmaId(request.getTurmaId());
        
        Matricula salva = matriculaRepository.save(matricula);
        return new MatriculaResponse(salva.getId(), salva.getDataMatricula(), salva.getAlunoId(), salva.getTurmaId());
    }

    public List<MatriculaResponse> listarTodas() {
        return matriculaRepository.findAll().stream()
                .map(m -> new MatriculaResponse(m.getId(), m.getDataMatricula(), m.getAlunoId(), m.getTurmaId()))
                .collect(Collectors.toList());
    }

    public List<MatriculaResponse> buscarPorAluno(Long alunoId) {
        return matriculaRepository.findByAlunoId(alunoId).stream()
                .map(m -> new MatriculaResponse(m.getId(), m.getDataMatricula(), m.getAlunoId(), m.getTurmaId()))
                .collect(Collectors.toList());
    }

    public MatriculaResponse atualizar(Long id, MatriculaRequest request) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula nao encontrada com o ID: " + id));
        
        matricula.setDataMatricula(request.getDataMatricula());
        matricula.setAlunoId(request.getAlunoId());
        matricula.setTurmaId(request.getTurmaId());
        
        Matricula atualizada = matriculaRepository.save(matricula);
        return new MatriculaResponse(atualizada.getId(), atualizada.getDataMatricula(), atualizada.getAlunoId(), atualizada.getTurmaId());
    }

    public void deletar(Long id) {
        if (!matriculaRepository.existsById(id)) {
            throw new RuntimeException("Matricula nao encontrada com o ID: " + id);
        }
        matriculaRepository.deleteById(id);
    }
}