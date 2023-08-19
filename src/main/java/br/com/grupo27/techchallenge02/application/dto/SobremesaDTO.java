package br.com.grupo27.techchallenge02.application.dto;

import java.math.BigDecimal;

import br.com.grupo27.techchallenge02.core.entities.model.Sobremesa;

public record SobremesaDTO(Long id, String nome, String descricao, BigDecimal preco) {

    public Sobremesa toSobremesa() {
        return new Sobremesa(this.id, this.nome, this.descricao, this.preco);
    }
}
