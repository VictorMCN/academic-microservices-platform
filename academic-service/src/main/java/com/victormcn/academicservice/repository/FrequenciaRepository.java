package com.victormcn.academicservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.victormcn.academicservice.model.Frequencia;

public interface FrequenciaRepository extends JpaRepository<Frequencia, Long> {
    List<Frequencia> findByAlunoId(Long alunoId);
}