package br.com.grupo27.techchallenge02.core.entities.model;

import java.math.BigDecimal;

import br.com.grupo27.techchallenge02.application.dto.SobremesaDTO;
import br.com.grupo27.techchallenge02.core.entities.model.abstractions.Produto;
import br.com.grupo27.techchallenge02.external.infrastructure.dataBaseEntities.SobremesaEntity;
public class Sobremesa extends Produto {
    public Sobremesa(Long id, String nome, String descricao, BigDecimal preco) {
        super(id, nome, descricao, preco);
    }

    public SobremesaDTO toDTO() {
        return new SobremesaDTO(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }

        public SobremesaEntity toEntity() {
        return new SobremesaEntity(this.getId(), this.getNome(), this.getDescricao(), this.getPreco());
    }
 
}

