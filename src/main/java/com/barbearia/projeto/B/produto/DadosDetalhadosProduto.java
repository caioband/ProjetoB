package com.barbearia.projeto.B.produto;

public record DadosDetalhadosProduto(long id, String nome, double preco, long vendas) {
    public DadosDetalhadosProduto(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getVendas());
    }
}
