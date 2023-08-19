package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.usecase;

import java.util.List;

import br.com.grupo27.techchallenge02.application.dto.LancheDTO;

public interface LancheService {
  
    LancheDTO getLancheById(Long id);

    List<LancheDTO> getAllLanches();

    LancheDTO createLanche(LancheDTO lancheDTO);

    LancheDTO updateLanche(Long id, LancheDTO lancheDTO);

    boolean deleteLanche(Long id);

}

