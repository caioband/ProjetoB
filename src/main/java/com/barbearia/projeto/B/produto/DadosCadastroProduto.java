package com.barbearia.projeto.B.produto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public record DadosCadastroProduto(@NotBlank String nome, @DecimalMin("0.0") double preco, @Range(min = 0) Integer vendas) {
}
