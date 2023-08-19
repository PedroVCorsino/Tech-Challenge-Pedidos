package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.repository;

import java.util.List;

import br.com.grupo27.techchallenge02.core.entities.model.Bebida;

public interface BebidaRepositoryPort {
    Bebida saveBebida(Bebida bebida);
    Bebida updateBebida(Long id, Bebida bebida);
    Bebida findBebidaById(Long id);
    boolean deleteBebida(Long id);
    List<Bebida> listAllBebidas();
}
