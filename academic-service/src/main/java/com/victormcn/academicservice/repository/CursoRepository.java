package com.victormcn.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victormcn.academicservice.model.Curso;

public interface CursoRepository
        extends JpaRepository<Curso, Long> {
}