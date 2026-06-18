package com.victormcn.academicservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.victormcn.academicservice.dto.TurmaRequest;
import com.victormcn.academicservice.dto.TurmaResponse;
import com.victormcn.academicservice.model.Curso;
import com.victormcn.academicservice.model.Professor;
import com.victormcn.academicservice.model.Turma;
import com.victormcn.academicservice.repository.CursoRepository;
import com.victormcn.academicservice.repository.ProfessorRepository;
import com.victormcn.academicservice.repository.TurmaRepository;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;

    public TurmaService(
            TurmaRepository turmaRepository,
            CursoRepository cursoRepository,
            ProfessorRepository professorRepository) {

        this.turmaRepository = turmaRepository;
        this.cursoRepository = cursoRepository;
        this.professorRepository = professorRepository;
    }

    public TurmaResponse salvar(
            TurmaRequest request) {

        Curso curso =
                cursoRepository.findById(
                        request.getCursoId())
                        .orElseThrow();

        Professor professor =
                professorRepository.findById(
                        request.getProfessorId())
                        .orElseThrow();

        Turma turma = new Turma();

        turma.setNome(request.getNome());
        turma.setSemestre(request.getSemestre());
        turma.setCurso(curso);
        turma.setProfessor(professor);

        Turma salva =
                turmaRepository.save(turma);

        return new TurmaResponse(
                salva.getId(),
                salva.getNome(),
                salva.getSemestre(),
                salva.getCurso().getId(),
                salva.getProfessor().getId());
    }

    public List<TurmaResponse> listarTodos() {

        return turmaRepository.findAll()
                .stream()
                .map(turma ->
                        new TurmaResponse(
                                turma.getId(),
                                turma.getNome(),
                                turma.getSemestre(),
                                turma.getCurso().getId(),
                                turma.getProfessor().getId()))
                .toList();
    }
}