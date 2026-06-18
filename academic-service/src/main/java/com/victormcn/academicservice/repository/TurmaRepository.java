package com.victormcn.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victormcn.academicservice.model.Turma;

public interface TurmaRepository
        extends JpaRepository<Turma, Long> {
}