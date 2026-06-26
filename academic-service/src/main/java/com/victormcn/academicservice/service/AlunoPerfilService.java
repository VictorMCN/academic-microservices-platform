package com.victormcn.academicservice.service;

import org.springframework.stereotype.Service;
import com.victormcn.academicservice.dto.PerfilCompletoAlunoResponse;
import com.victormcn.academicservice.dto.UsuarioResponse;
import java.util.List;

@Service
public class AlunoPerfilService {

    private final MatriculaService matriculaService;
    private final NotaService notaService;
    private final FrequenciaService frequenciaService;
    private final AuthClientService authClientService;

    public AlunoPerfilService(MatriculaService matriculaService, 
                              NotaService notaService, 
                              FrequenciaService frequenciaService,
                              AuthClientService authClientService) {
        this.matriculaService = matriculaService;
        this.notaService = notaService;
        this.frequenciaService = frequenciaService;
        this.authClientService = authClientService;
    }

    public PerfilCompletoAlunoResponse obterPerfilCompleto(Long alunoId, String usernameLogado, String roles) {
        // Se for apenas ALUNO, valida se o ID requisitado condiz com o token logado
        if (roles.contains("ALUNO") && !roles.contains("ADMIN") && !roles.contains("PROFESSOR")) {
            try {
                // Busca o usuário logado no auth-service para validar o ID real dele
                UsuarioResponse usuarioLogado = authClientService.buscarPorId(alunoId);
                if (usuarioLogado == null || !usuarioLogado.getNome().equals(usernameLogado)) {
                    throw new RuntimeException("Acesso negado: Voce so pode consultar seus proprios dados.");
                }
            } catch (Exception e) {
                throw new RuntimeException("Acesso negado: Nao foi possivel validar os dados do aluno. " + e.getMessage());
            }
        }
        
        return new PerfilCompletoAlunoResponse(
            alunoId,
            matriculaService.buscarPorAluno(alunoId),
            notaService.buscarPorAluno(alunoId),
            frequenciaService.buscarPorAluno(alunoId)
        );
    }
}