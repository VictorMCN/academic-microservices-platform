package com.victormcn.academicservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.victormcn.academicservice.dto.AlunoRequest;
import com.victormcn.academicservice.dto.AlunoResponse;
import com.victormcn.academicservice.model.Aluno;
import com.victormcn.academicservice.repository.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(
            AlunoRepository alunoRepository) {

        this.alunoRepository = alunoRepository;
    }

    public AlunoResponse salvar(
            AlunoRequest request) {

        Aluno aluno = new Aluno();

        aluno.setNome(request.getNome());
        aluno.setEmail(request.getEmail());

        Aluno alunoSalvo =
                alunoRepository.save(aluno);

        return new AlunoResponse(
                alunoSalvo.getId(),
                alunoSalvo.getNome(),
                alunoSalvo.getEmail());
    }

    public List<AlunoResponse> listarTodos() {

        return alunoRepository.findAll()
                .stream()
                .map(aluno ->
                        new AlunoResponse(
                                aluno.getId(),
                                aluno.getNome(),
                                aluno.getEmail()))
                .toList();
    }
}