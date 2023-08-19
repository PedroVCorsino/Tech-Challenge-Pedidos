package br.com.grupo27.techchallenge02.application.config.mappers.produtos;

import org.springframework.stereotype.Component;

import br.com.grupo27.techchallenge02.application.dto.AcompanhamentoDTO;
import br.com.grupo27.techchallenge02.core.entities.model.Acompanhamento;
import br.com.grupo27.techchallenge02.external.infrastructure.dataBaseEntities.AcompanhamentoEntity;

@Component
public class AcompanhamentoMapper {

    public AcompanhamentoEntity domainToEntity(Acompanhamento acompanhamento) {
        return new AcompanhamentoEntity(
                acompanhamento.getId(),
                acompanhamento.getNome(),
                acompanhamento.getDescricao(),
                acompanhamento.getPreco()
        );
    }

    public Acompanhamento dtoToDomain(AcompanhamentoDTO acompanhamentoDTO) {
        return new Acompanhamento(
                acompanhamentoDTO.id(),
                acompanhamentoDTO.nome(),
                acompanhamentoDTO.descricao(),
                acompanhamentoDTO.preco()
        );
    }

    public AcompanhamentoDTO domainToDto(Acompanhamento acompanhamento) {
        return new AcompanhamentoDTO(
                acompanhamento.getId(),
                acompanhamento.getNome(),
                acompanhamento.getDescricao(),
                acompanhamento.getPreco()
        );
    }

    public Acompanhamento entityToDomain(AcompanhamentoEntity acompanhamentoEntity) {
        return new Acompanhamento(
                acompanhamentoEntity.getId(),
                acompanhamentoEntity.getNome(),
                acompanhamentoEntity.getDescricao(),
                acompanhamentoEntity.getPreco()
        );
    }
}
