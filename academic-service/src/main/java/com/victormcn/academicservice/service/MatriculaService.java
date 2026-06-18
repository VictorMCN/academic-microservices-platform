package com.victormcn.academicservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.victormcn.academicservice.dto.MatriculaRequest;
import com.victormcn.academicservice.dto.MatriculaResponse;
import com.victormcn.academicservice.model.Aluno;
import com.victormcn.academicservice.model.Matricula;
import com.victormcn.academicservice.model.Turma;
import com.victormcn.academicservice.repository.AlunoRepository;
import com.victormcn.academicservice.repository.MatriculaRepository;
import com.victormcn.academicservice.repository.TurmaRepository;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public MatriculaService(
            MatriculaRepository matriculaRepository,
            AlunoRepository alunoRepository,
            TurmaRepository turmaRepository) {

        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    public MatriculaResponse salvar(
            MatriculaRequest request) {

        Aluno aluno =
                alunoRepository.findById(
                        request.getAlunoId())
                        .orElseThrow();

        Turma turma =
                turmaRepository.findById(
                        request.getTurmaId())
                        .orElseThrow();

        Matricula matricula = new Matricula();

        matricula.setDataMatricula(
                request.getDataMatricula());

        matricula.setAluno(aluno);
        matricula.setTurma(turma);

        Matricula salva =
                matriculaRepository.save(matricula);

        return new MatriculaResponse(
                salva.getId(),
                salva.getDataMatricula(),
                salva.getAluno().getId(),
                salva.getTurma().getId());
    }

    public List<MatriculaResponse> listarTodos() {

        return matriculaRepository.findAll()
                .stream()
                .map(matricula ->
                        new MatriculaResponse(
                                matricula.getId(),
                                matricula.getDataMatricula(),
                                matricula.getAluno().getId(),
                                matricula.getTurma().getId()))
                .toList();
    }
}