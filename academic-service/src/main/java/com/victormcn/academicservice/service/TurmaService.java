package com.victormcn.academicservice.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.victormcn.academicservice.dto.TurmaRequest;
import com.victormcn.academicservice.dto.TurmaResponse;
import com.victormcn.academicservice.model.Turma;
import com.victormcn.academicservice.repository.TurmaRepository;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public TurmaResponse salvar(TurmaRequest request) {
        Turma turma = new Turma();
        turma.setNome(request.getNome());
        turma.setSemestre(request.getSemestre());
        turma.setCursoId(request.getCursoId());
        turma.setProfessorId(request.getProfessorId());
        
        Turma salva = turmaRepository.save(turma);
        return new TurmaResponse(salva.getId(), salva.getNome(), salva.getSemestre(), salva.getCursoId(), salva.getProfessorId());
    }

    public List<TurmaResponse> listarTodos() {
        return turmaRepository.findAll().stream()
                .map(t -> new TurmaResponse(t.getId(), t.getNome(), t.getSemestre(), t.getCursoId(), t.getProfessorId()))
                .collect(Collectors.toList());
    }

    public TurmaResponse buscarPorId(Long id) {
        Turma t = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma nao encontrada com o ID: " + id));
        return new TurmaResponse(t.getId(), t.getNome(), t.getSemestre(), t.getCursoId(), t.getProfessorId());
    }

    public TurmaResponse atualizar(Long id, TurmaRequest request) {
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma nao encontrada com o ID: " + id));
        
        turma.setNome(request.getNome());
        turma.setSemestre(request.getSemestre());
        turma.setCursoId(request.getCursoId());
        turma.setProfessorId(request.getProfessorId());
        
        Turma atualizada = turmaRepository.save(turma);
        return new TurmaResponse(atualizada.getId(), atualizada.getNome(), atualizada.getSemestre(), atualizada.getCursoId(), atualizada.getProfessorId());
    }

    public void deletar(Long id) {
        if (!turmaRepository.existsById(id)) {
            throw new RuntimeException("Turma nao encontrada com o ID: " + id);
        }
        turmaRepository.deleteById(id);
    }
}