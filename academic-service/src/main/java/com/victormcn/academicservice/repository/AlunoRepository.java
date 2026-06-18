package com.victormcn.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victormcn.academicservice.model.Aluno;

public interface AlunoRepository
        extends JpaRepository<Aluno, Long> {
}