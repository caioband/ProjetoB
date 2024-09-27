package com.barbearia.projeto.B.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(@NotNull Long id, String nome) {

}
