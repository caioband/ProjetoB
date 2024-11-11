package com.barbearia.projeto.B.usuario;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Table(name = "usuarios")
@Entity(name = "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.senha = dados.senha();
        System.out.println(this.getId());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String senha;

    public void atualizarInformacoes(@Valid DadosAtualizarUsuario dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
    }

}
