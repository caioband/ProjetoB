package com.barbearia.projeto.B.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(@NotBlank String nome) {

}
