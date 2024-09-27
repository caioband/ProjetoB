package com.barbearia.projeto.B.usuario;

public record DadosDetalhadosUsuario(String nome, int banido) {
        public DadosDetalhadosUsuario(Usuario usuario){
            this(usuario.getNome(),usuario.getBanido());
        }

}
