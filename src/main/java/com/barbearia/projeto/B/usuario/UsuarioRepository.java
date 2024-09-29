package com.barbearia.projeto.B.usuario;

import org.flywaydb.core.internal.util.JsonUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    List<Usuario> findAllByBanidoFalse();
}
