package com.victormcn.academicservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victormcn.academicservice.model.Matricula;

public interface MatriculaRepository
        extends JpaRepository<Matricula, Long> {

    List<Matricula> findByAlunoId(Long alunoId);
}