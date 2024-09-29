package com.barbearia.projeto.B.usuario;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

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
        System.out.println(this.getId());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;

    private boolean banido;

    public void atualizarInformacoes(@Valid DadosAtualizarUsuario dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
            this.banido = false;
        }
    }
    public void banir(){
        this.banido = true;
    }

    public void desbanir(){
        this.banido = false;
    }

    public boolean getBanido() {
        return this.banido;
    }
}
