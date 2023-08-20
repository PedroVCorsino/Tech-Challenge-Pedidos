package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.repository;

import java.util.List;

import br.com.grupo27.techchallenge02.Domain.enums.Categoria;
import br.com.grupo27.techchallenge02.Domain.model.Produto;

public interface ProdutoRepositoryPort {
    Produto saveProduto(Produto produto);
    Produto updateProduto(Long id, Produto produto);
    Produto findProdutoById(Long id);
    boolean deleteProduto(Long id);
    List<Produto> listAllProdutos();
    List<Produto> listByCategoria(Categoria categoria);
}
