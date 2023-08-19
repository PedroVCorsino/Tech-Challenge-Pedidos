package br.com.grupo27.techchallenge02.external.infrastructure.repositories;

import org.springframework.stereotype.Repository;

import br.com.grupo27.techchallenge02.core.entities.model.Acompanhamento;
import br.com.grupo27.techchallenge02.external.infrastructure.dataBaseEntities.AcompanhamentoEntity;
import br.com.grupo27.techchallenge02.external.infrastructure.repositories.JPA.AcompanhamentoJPA;
import br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.repository.AcompanhamentoRepositoryPort;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AcompanhamentoRepositoryAdapter implements AcompanhamentoRepositoryPort {

    private final AcompanhamentoJPA acompanhamentoRepositoryJPA;

    public AcompanhamentoRepositoryAdapter(AcompanhamentoJPA acompanhamentoRepositoryJPA) {
        this.acompanhamentoRepositoryJPA = acompanhamentoRepositoryJPA;
    }

    @Override
    public Acompanhamento saveAcompanhamento(Acompanhamento acompanhamento) {
        AcompanhamentoEntity acompanhamentoEntity = acompanhamento.toEntity();
        acompanhamentoEntity = acompanhamentoRepositoryJPA.save(acompanhamentoEntity);
        return acompanhamentoEntity.toAcompanhamento();
    }

    @Override
    public Acompanhamento updateAcompanhamento(Long id, Acompanhamento acompanhamento) {
        return acompanhamentoRepositoryJPA.findById(id).map(acompanhamentoEntity -> {
            acompanhamentoEntity.setNome(acompanhamento.getNome());
            acompanhamentoEntity.setDescricao(acompanhamento.getDescricao());
            acompanhamentoEntity.setPreco(acompanhamento.getPreco());
            acompanhamentoEntity = acompanhamentoRepositoryJPA.save(acompanhamentoEntity);
            return acompanhamentoEntity.toAcompanhamento();
        }).orElse(null);
    }

    @Override
    public Acompanhamento findAcompanhamentoById(Long id) {
        return acompanhamentoRepositoryJPA.findById(id).map(AcompanhamentoEntity::toAcompanhamento).orElse(null);
    }

    @Override
    public boolean deleteAcompanhamento(Long id) {
        if (acompanhamentoRepositoryJPA.existsById(id)) {
            acompanhamentoRepositoryJPA.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Acompanhamento> listAllAcompanhamentos() {
        return acompanhamentoRepositoryJPA.findAll().stream()
                .map(AcompanhamentoEntity::toAcompanhamento)
                .collect(Collectors.toList());
    }
}
