package com.victormcn.academicservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.victormcn.academicservice.dto.NotaRequest;
import com.victormcn.academicservice.dto.NotaResponse;
import com.victormcn.academicservice.model.Aluno;
import com.victormcn.academicservice.model.Nota;
import com.victormcn.academicservice.model.Turma;
import com.victormcn.academicservice.repository.AlunoRepository;
import com.victormcn.academicservice.repository.NotaRepository;
import com.victormcn.academicservice.repository.TurmaRepository;

@Service
public class NotaService {

    private final NotaRepository notaRepository;
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public NotaService(
            NotaRepository notaRepository,
            AlunoRepository alunoRepository,
            TurmaRepository turmaRepository) {

        this.notaRepository = notaRepository;
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    public NotaResponse salvar(
            NotaRequest request) {

        Aluno aluno =
                alunoRepository.findById(
                        request.getAlunoId())
                        .orElseThrow();

        Turma turma =
                turmaRepository.findById(
                        request.getTurmaId())
                        .orElseThrow();

        Nota nota = new Nota();

        nota.setValor(request.getValor());
        nota.setAluno(aluno);
        nota.setTurma(turma);

        Nota salva =
                notaRepository.save(nota);

        return new NotaResponse(
                salva.getId(),
                salva.getValor(),
                salva.getAluno().getId(),
                salva.getTurma().getId());
    }

    public List<NotaResponse> listarTodos() {

        return notaRepository.findAll()
                .stream()
                .map(nota ->
                        new NotaResponse(
                                nota.getId(),
                                nota.getValor(),
                                nota.getAluno().getId(),
                                nota.getTurma().getId()))
                .toList();
    }
}