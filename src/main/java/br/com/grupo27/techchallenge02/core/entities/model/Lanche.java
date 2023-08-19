package br.com.grupo27.techchallenge02.core.entities.model;

import java.math.BigDecimal;

import br.com.grupo27.techchallenge02.application.dto.LancheDTO;
import br.com.grupo27.techchallenge02.core.entities.model.abstractions.Produto;
import br.com.grupo27.techchallenge02.external.infrastructure.dataBaseEntities.LancheEntity;

public class Lanche extends Produto {
    public Lanche(Long id, String nome, String descricao, BigDecimal preco) {
        super(id, nome, descricao, preco);
    }

    public LancheDTO toDTO() {
        return new LancheDTO(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }

    public LancheEntity toEntity() {
        return new LancheEntity(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }

}
