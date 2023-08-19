package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.usecase;

import java.util.List;

import br.com.grupo27.techchallenge02.application.dto.ProdutoDTO;

public interface ProdutoService {
    List<ProdutoDTO> getAllProdutos();

    List<ProdutoDTO> getProdutosByTipo(String tipo);
    
}
