package br.com.grupo27.techchallenge03.application.dto;

import java.math.BigDecimal;

import br.com.grupo27.techchallenge03.domain.enums.Categoria;
import br.com.grupo27.techchallenge03.domain.model.Produto;

public record ProdutoDTO(Long id, String nome, String descricao, BigDecimal preco, Categoria categoria) {
    public Produto toProduto() {
        return new Produto(this.id, this.nome, this.descricao, this.preco, this.categoria);
    }
}