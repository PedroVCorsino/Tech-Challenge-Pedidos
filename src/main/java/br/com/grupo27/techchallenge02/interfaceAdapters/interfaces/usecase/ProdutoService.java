package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.usecase;

import java.util.List;

import br.com.grupo27.techchallenge02.Domain.enums.Categoria;
import br.com.grupo27.techchallenge02.application.dto.ProdutoDTO;

public interface ProdutoService {

    ProdutoDTO getProdutoById(Long id);

    ProdutoDTO createProduto(ProdutoDTO produtoDTO);

    ProdutoDTO updateProduto(Long id, ProdutoDTO produtoDTO);

    boolean deleteProduto(Long id);
    List<ProdutoDTO> getAllProdutos();

    List<ProdutoDTO> getProdutosByCategoria(Categoria categoria);
    
}
