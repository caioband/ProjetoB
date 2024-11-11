package com.barbearia.projeto.B.usuario;

public record DadosListagemUsuarios(Long id,String nome) {
    public DadosListagemUsuarios(Usuario usuario) {
        this(usuario.getId(), usuario.getNome());
    }
}
