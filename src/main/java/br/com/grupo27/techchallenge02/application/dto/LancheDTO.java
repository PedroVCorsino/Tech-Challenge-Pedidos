package br.com.grupo27.techchallenge02.application.dto;

import java.math.BigDecimal;

import br.com.grupo27.techchallenge02.core.entities.model.Lanche;

public record LancheDTO(Long id, String nome, String descricao, BigDecimal preco) {

    public Lanche toLanche() {
        return new Lanche(this.id, this.nome, this.descricao, this.preco);
    }
}
