package com.victormcn.academicservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.victormcn.academicservice.dto.CursoRequest;
import com.victormcn.academicservice.dto.CursoResponse;
import com.victormcn.academicservice.model.Curso;
import com.victormcn.academicservice.repository.CursoRepository;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(
            CursoRepository cursoRepository) {

        this.cursoRepository = cursoRepository;
    }

    public CursoResponse salvar(
            CursoRequest request) {

        Curso curso = new Curso();

        curso.setNome(request.getNome());
        curso.setDescricao(request.getDescricao());

        Curso salvo =
                cursoRepository.save(curso);

        return new CursoResponse(
                salvo.getId(),
                salvo.getNome(),
                salvo.getDescricao());
    }

    public List<CursoResponse> listarTodos() {

        return cursoRepository.findAll()
                .stream()
                .map(curso ->
                        new CursoResponse(
                                curso.getId(),
                                curso.getNome(),
                                curso.getDescricao()))
                .toList();
    }

    public CursoResponse buscarPorId(Long id) {

        Curso curso =
                cursoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Curso não encontrado"));

        return new CursoResponse(
                curso.getId(),
                curso.getNome(),
                curso.getDescricao());
    }

    public CursoResponse atualizar(
            Long id,
            CursoRequest request) {

        Curso curso =
                cursoRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Curso não encontrado"));

        curso.setNome(request.getNome());
        curso.setDescricao(request.getDescricao());

        Curso atualizado =
                cursoRepository.save(curso);

        return new CursoResponse(
                atualizado.getId(),
                atualizado.getNome(),
                atualizado.getDescricao());
    }

    public void deletar(Long id) {

        cursoRepository.deleteById(id);
    }
}