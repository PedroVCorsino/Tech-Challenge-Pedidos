package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.repository;

import java.util.List;

import br.com.grupo27.techchallenge02.core.entities.model.Acompanhamento;

public interface AcompanhamentoRepositoryPort {
    Acompanhamento saveAcompanhamento(Acompanhamento acompanhamento);
    Acompanhamento updateAcompanhamento(Long id, Acompanhamento acompanhamento);
    Acompanhamento findAcompanhamentoById(Long id);
    boolean deleteAcompanhamento(Long id);
    List<Acompanhamento> listAllAcompanhamentos();
}
