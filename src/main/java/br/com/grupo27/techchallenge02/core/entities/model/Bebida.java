package br.com.grupo27.techchallenge02.core.entities.model;

import java.math.BigDecimal;

import br.com.grupo27.techchallenge02.application.dto.BebidaDTO;
import br.com.grupo27.techchallenge02.core.entities.model.abstractions.Produto;
import br.com.grupo27.techchallenge02.external.infrastructure.dataBaseEntities.BebidaEntity;
public class Bebida extends Produto {
    public Bebida(Long id, String nome, String descricao, BigDecimal preco) {
        super(id, nome, descricao, preco);
    }

    public Bebida(Long id, String nome, BigDecimal preco) {
    }

    public BebidaDTO toDTO() {
        return new BebidaDTO(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }

    public BebidaEntity toEntity() {
        return new BebidaEntity(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }
    
}

