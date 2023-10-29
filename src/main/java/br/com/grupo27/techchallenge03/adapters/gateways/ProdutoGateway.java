package br.com.grupo27.techchallenge03.adapters.gateways;

import java.util.List;

import br.com.grupo27.techchallenge03.domain.enums.Categoria;
import br.com.grupo27.techchallenge03.domain.model.Produto;

public interface ProdutoGateway {
    Produto saveProduto(Produto produto);
    Produto updateProduto(Long id, Produto produto);
    Produto findProdutoById(Long id);
    boolean deleteProduto(Long id);
    List<Produto> listAllProdutos();
    List<Produto> listByCategoria(Categoria categoria);
}
