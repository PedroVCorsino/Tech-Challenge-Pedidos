package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.repository;

import java.util.List;

import br.com.grupo27.techchallenge02.core.entities.model.Sobremesa;

public interface SobremesaRepositoryPort {
    Sobremesa saveSobremesa(Sobremesa sobremesa);
    Sobremesa updateSobremesa(Long id, Sobremesa sobremesa);
    Sobremesa findSobremesaById(Long id);
    boolean deleteSobremesa(Long id);
    List<Sobremesa> listAllSobremesas();
}
