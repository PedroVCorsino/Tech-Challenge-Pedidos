package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.usecase;

import java.util.List;

import br.com.grupo27.techchallenge02.application.dto.AcompanhamentoDTO;

public interface AcompanhamentoService {
  
    AcompanhamentoDTO getAcompanhamentoById(Long id);

    List<AcompanhamentoDTO> getAllAcompanhamentos();

    AcompanhamentoDTO createAcompanhamento(AcompanhamentoDTO acompanhamentoDTO);

    AcompanhamentoDTO updateAcompanhamento(Long id, AcompanhamentoDTO acompanhamentoDTO);

    boolean deleteAcompanhamento(Long id);
}
