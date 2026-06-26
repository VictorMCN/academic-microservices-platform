package com.victormcn.authservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.victormcn.authservice.model.Usuario;
import com.victormcn.authservice.model.Role;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNome(String nome);
    List<Usuario> findByRole(Role role);
}