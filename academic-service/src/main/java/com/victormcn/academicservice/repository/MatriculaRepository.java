package com.victormcn.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victormcn.academicservice.model.Matricula;

public interface MatriculaRepository
        extends JpaRepository<Matricula, Long> {
}