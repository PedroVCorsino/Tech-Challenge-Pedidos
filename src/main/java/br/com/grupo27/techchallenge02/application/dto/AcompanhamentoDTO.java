package br.com.grupo27.techchallenge02.application.dto;

import java.math.BigDecimal;

import br.com.grupo27.techchallenge02.core.entities.model.Acompanhamento;

public record AcompanhamentoDTO(Long id, String nome, String descricao, BigDecimal preco) {

    public Acompanhamento toAcompanhamento() {
        return new Acompanhamento(this.id, this.nome, this.descricao, this.preco);
    }
    
}