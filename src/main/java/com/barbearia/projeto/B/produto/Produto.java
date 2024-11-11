package com.barbearia.projeto.B.produto;

import com.barbearia.projeto.B.usuario.DadosAtualizarUsuario;
import com.barbearia.projeto.B.usuario.DadosCadastroUsuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Range;


@Table(name = "produtos")
@Entity(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.vendas = dados.vendas();
        this.preco = dados.preco();
        System.out.println(this.getId());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    @Range(min = 0)
    private long vendas;
    @DecimalMin("0.0")
    private double preco;

    public void atualizarInformacoes(@Valid DadosAtualizarProduto dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
            this.preco = dados.preco();
            this.vendas = dados.vendas();
        }
    }

}
