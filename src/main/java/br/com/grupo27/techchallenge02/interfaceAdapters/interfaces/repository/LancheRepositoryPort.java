package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.repository;

import java.util.List;

import br.com.grupo27.techchallenge02.core.entities.model.Lanche;

public interface LancheRepositoryPort {
    Lanche saveLanche(Lanche lanche);
    Lanche updateLanche(Long id, Lanche lanche);
    Lanche findLancheById(Long id);
    boolean deleteLanche(Long id);
    List<Lanche> listAllLanches();
}
