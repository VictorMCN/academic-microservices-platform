package com.victormcn.academicservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victormcn.academicservice.model.Nota;

public interface NotaRepository
        extends JpaRepository<Nota, Long> {

    List<Nota> findByAlunoId(Long alunoId);
}