package com.barbearia.projeto.B.usuario;

import org.flywaydb.core.internal.util.JsonUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    @Query("from usuario u where u.nome = :nome and u.senha = :pass")
    List<Usuario> GetUserByNameAndPass(String nome, String pass);

}
