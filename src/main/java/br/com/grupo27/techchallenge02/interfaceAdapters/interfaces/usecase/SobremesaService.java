package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.usecase;

import java.util.List;

import br.com.grupo27.techchallenge02.application.dto.SobremesaDTO;

public interface SobremesaService {
  
    SobremesaDTO getSobremesaById(Long id);

    List<SobremesaDTO> getAllSobremesas();

    SobremesaDTO createSobremesa(SobremesaDTO sobremesaDTO);

    SobremesaDTO updateSobremesa(Long id, SobremesaDTO sobremesaDTO);

    boolean deleteSobremesa(Long id);
}
