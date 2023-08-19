package br.com.grupo27.techchallenge02.application.config.mappers.produtos;

import org.springframework.stereotype.Component;

import br.com.grupo27.techchallenge02.application.dto.BebidaDTO;
import br.com.grupo27.techchallenge02.core.entities.model.Bebida;
import br.com.grupo27.techchallenge02.external.infrastructure.dataBaseEntities.BebidaEntity;

@Component
public class BebidaMapper {

    public BebidaEntity domainToEntity(Bebida bebida) {
        return new BebidaEntity(
                bebida.getId(),
                bebida.getNome(),
                bebida.getDescricao(),
                bebida.getPreco()
        );
    }

    public Bebida dtoToDomain(BebidaDTO bebidaDTO) {
        return new Bebida(
                bebidaDTO.id(),
                bebidaDTO.nome(),
                bebidaDTO.descricao(),
                bebidaDTO.preco()
        );
    }

    public BebidaDTO domainToDto(Bebida bebida) {
        return new BebidaDTO(
                bebida.getId(),
                bebida.getNome(),
                bebida.getDescricao(),
                bebida.getPreco()
        );
    }

    public Bebida entityToDomain(BebidaEntity bebidaEntity) {
        return new Bebida(
                bebidaEntity.getId(),
                bebidaEntity.getNome(),
                bebidaEntity.getDescricao(),
                bebidaEntity.getPreco()
        );
    }
}
