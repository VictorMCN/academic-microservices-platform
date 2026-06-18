package com.victormcn.academicservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.victormcn.academicservice.dto.ProfessorRequest;
import com.victormcn.academicservice.dto.ProfessorResponse;
import com.victormcn.academicservice.model.Professor;
import com.victormcn.academicservice.repository.ProfessorRepository;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(
            ProfessorRepository professorRepository) {

        this.professorRepository = professorRepository;
    }

    public ProfessorResponse salvar(
            ProfessorRequest request) {

        Professor professor = new Professor();

        professor.setNome(request.getNome());
        professor.setEmail(request.getEmail());

        Professor salvo =
                professorRepository.save(professor);

        return new ProfessorResponse(
                salvo.getId(),
                salvo.getNome(),
                salvo.getEmail());
    }

    public List<ProfessorResponse> listarTodos() {

        return professorRepository.findAll()
                .stream()
                .map(professor ->
                        new ProfessorResponse(
                                professor.getId(),
                                professor.getNome(),
                                professor.getEmail()))
                .toList();
    }
}