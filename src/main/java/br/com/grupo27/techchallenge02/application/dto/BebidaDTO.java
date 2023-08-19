package br.com.grupo27.techchallenge02.application.dto;

import java.math.BigDecimal;

import br.com.grupo27.techchallenge02.core.entities.model.Bebida;

public record BebidaDTO(Long id, String nome, String descricao, BigDecimal preco) {

    public Bebida toBebida() {
        return new Bebida(this.id, this.nome, this.descricao, this.preco);
    }
}
