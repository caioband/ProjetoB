package com.barbearia.projeto.B.produto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarProduto(@NotNull Long id, String nome, double preco, long vendas) {

}
