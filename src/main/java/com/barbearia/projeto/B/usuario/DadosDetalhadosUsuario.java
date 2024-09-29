package com.barbearia.projeto.B.usuario;

public record DadosDetalhadosUsuario(long id,String nome, boolean banido) {
        public DadosDetalhadosUsuario(Usuario usuario){
            this(usuario.getId(),usuario.getNome(),usuario.getBanido());
        }

}
