package com.victormcn.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victormcn.academicservice.model.Nota;

public interface NotaRepository
        extends JpaRepository<Nota, Long> {
}