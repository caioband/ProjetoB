package com.barbearia.projeto.B.usuario;

public record DadosDetalhadosUsuario(long id,String nome) {
        public DadosDetalhadosUsuario(Usuario usuario){
            this(usuario.getId(),usuario.getNome());
        }

}
