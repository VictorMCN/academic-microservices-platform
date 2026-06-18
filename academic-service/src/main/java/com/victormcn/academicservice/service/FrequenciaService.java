package com.victormcn.academicservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.victormcn.academicservice.dto.FrequenciaRequest;
import com.victormcn.academicservice.dto.FrequenciaResponse;
import com.victormcn.academicservice.model.Aluno;
import com.victormcn.academicservice.model.Frequencia;
import com.victormcn.academicservice.model.Turma;
import com.victormcn.academicservice.repository.AlunoRepository;
import com.victormcn.academicservice.repository.FrequenciaRepository;
import com.victormcn.academicservice.repository.TurmaRepository;

@Service
public class FrequenciaService {

    private final FrequenciaRepository frequenciaRepository;
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public FrequenciaService(
            FrequenciaRepository frequenciaRepository,
            AlunoRepository alunoRepository,
            TurmaRepository turmaRepository) {

        this.frequenciaRepository = frequenciaRepository;
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    public FrequenciaResponse salvar(
            FrequenciaRequest request) {

        Aluno aluno =
                alunoRepository.findById(
                        request.getAlunoId())
                        .orElseThrow();

        Turma turma =
                turmaRepository.findById(
                        request.getTurmaId())
                        .orElseThrow();

        Frequencia frequencia =
                new Frequencia();

        frequencia.setFaltas(
                request.getFaltas());

        frequencia.setAluno(aluno);
        frequencia.setTurma(turma);

        Frequencia salva =
                frequenciaRepository.save(frequencia);

        return new FrequenciaResponse(
                salva.getId(),
                salva.getFaltas(),
                salva.getAluno().getId(),
                salva.getTurma().getId());
    }

    public List<FrequenciaResponse> listarTodos() {

        return frequenciaRepository.findAll()
                .stream()
                .map(freq ->
                        new FrequenciaResponse(
                                freq.getId(),
                                freq.getFaltas(),
                                freq.getAluno().getId(),
                                freq.getTurma().getId()))
                .toList();
    }
}