package com.victormcn.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victormcn.academicservice.model.Professor;

public interface ProfessorRepository
        extends JpaRepository<Professor, Long> {
}