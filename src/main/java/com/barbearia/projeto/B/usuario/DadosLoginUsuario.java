package com.barbearia.projeto.B.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosLoginUsuario(@NotBlank String nome, @NotBlank String senha) {
}
