package com.barbearia.projeto.B.produto;

import com.barbearia.projeto.B.usuario.DadosListagemUsuarios;

public record DadosListagemProduto(Long id, String nome, double preco, long vendas) {
    public DadosListagemProduto(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getVendas());
    }
}
