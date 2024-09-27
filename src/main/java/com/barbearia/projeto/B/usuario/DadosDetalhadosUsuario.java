package com.barbearia.projeto.B.usuario;

public record DadosDetalhadosUsuario(Long id, String nome, int banido) {
        public DadosDetalhadosUsuario(Usuario usuario){
            this(usuario.getId(),usuario.getNome(),usuario.getBanido());
        }

}
