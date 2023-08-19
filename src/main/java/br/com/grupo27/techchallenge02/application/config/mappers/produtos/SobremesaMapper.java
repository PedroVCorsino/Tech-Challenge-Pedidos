package br.com.grupo27.techchallenge02.application.config.mappers.produtos;

import org.springframework.stereotype.Component;

import br.com.grupo27.techchallenge02.application.dto.SobremesaDTO;
import br.com.grupo27.techchallenge02.core.entities.model.Sobremesa;
import br.com.grupo27.techchallenge02.external.infrastructure.dataBaseEntities.SobremesaEntity;

@Component
public class SobremesaMapper {

    public SobremesaEntity domainToEntity(Sobremesa sobremesa) {
        return new SobremesaEntity(
                sobremesa.getId(),
                sobremesa.getNome(),
                sobremesa.getDescricao(),
                sobremesa.getPreco()
        );
    }

    public Sobremesa dtoToDomain(SobremesaDTO sobremesaDTO) {
        return new Sobremesa(
                sobremesaDTO.id(),
                sobremesaDTO.nome(),
                sobremesaDTO.descricao(),
                sobremesaDTO.preco()
        );
    }

    public SobremesaDTO domainToDto(Sobremesa sobremesa) {
        return new SobremesaDTO(
                sobremesa.getId(),
                sobremesa.getNome(),
                sobremesa.getDescricao(),
                sobremesa.getPreco()
        );
    }

    public Sobremesa entityToDomain(SobremesaEntity sobremesaEntity) {
        return new Sobremesa(
                sobremesaEntity.getId(),
                sobremesaEntity.getNome(),
                sobremesaEntity.getDescricao(),
                sobremesaEntity.getPreco()
        );
    }
}
