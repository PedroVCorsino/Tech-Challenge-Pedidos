package br.com.grupo27.techchallenge02.core.entities.model;

import java.math.BigDecimal;

import br.com.grupo27.techchallenge02.application.dto.AcompanhamentoDTO;
import br.com.grupo27.techchallenge02.core.entities.model.abstractions.Produto;
import br.com.grupo27.techchallenge02.external.infrastructure.dataBaseEntities.AcompanhamentoEntity;

public class Acompanhamento extends Produto {
    public Acompanhamento(Long id, String nome, String descricao, BigDecimal preco) {
        super(id, nome, descricao, preco);
    }

    public Acompanhamento(Long id, String nome, BigDecimal preco) {
    }

    public AcompanhamentoDTO toDTO() {
        return new AcompanhamentoDTO(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }

    public AcompanhamentoEntity toEntity() {
        return new AcompanhamentoEntity(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }
}
