package com.victormcn.academicservice.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.victormcn.academicservice.dto.NotaRequest;
import com.victormcn.academicservice.dto.NotaResponse;
import com.victormcn.academicservice.model.Nota;
import com.victormcn.academicservice.repository.NotaRepository;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public NotaResponse salvar(NotaRequest request) {
        Nota nota = new Nota();
        nota.setValor(request.getValor());
        nota.setAlunoId(request.getAlunoId());
        nota.setTurmaId(request.getTurmaId());
        
        Nota salva = notaRepository.save(nota);
        return new NotaResponse(salva.getId(), salva.getValor(), salva.getAlunoId(), salva.getTurmaId());
    }

    public List<NotaResponse> listarTodas() {
        return notaRepository.findAll().stream()
                .map(n -> new NotaResponse(n.getId(), n.getValor(), n.getAlunoId(), n.getTurmaId()))
                .collect(Collectors.toList());
    }

    public List<NotaResponse> buscarPorAluno(Long alunoId) {
        return notaRepository.findByAlunoId(alunoId).stream()
                .map(n -> new NotaResponse(n.getId(), n.getValor(), n.getAlunoId(), n.getTurmaId()))
                .collect(Collectors.toList());
    }

    public List<NotaResponse> buscarPorAlunoComSeguranca(Long alunoId, String usernameLogado, boolean isAluno) {
        if (isAluno && !usernameLogado.equals(alunoId.toString())) {
            throw new RuntimeException("Acesso negado as notas deste aluno.");
        }
        return buscarPorAluno(alunoId);
    }

    public NotaResponse atualizar(Long id, NotaRequest request) {
        Nota nota = notaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota nao encontrada com o ID: " + id));
        
        nota.setValor(request.getValor());
        nota.setAlunoId(request.getAlunoId());
        nota.setTurmaId(request.getTurmaId());
        
        Nota atualizada = notaRepository.save(nota);
        return new NotaResponse(atualizada.getId(), atualizada.getValor(), atualizada.getAlunoId(), atualizada.getTurmaId());
    }

    public void deletar(Long id) {
        if (!notaRepository.existsById(id)) {
            throw new RuntimeException("Nota nao encontrada com o ID: " + id);
        }
        notaRepository.deleteById(id);
    }
}