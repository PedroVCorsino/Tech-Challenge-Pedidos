package br.com.grupo27.techchallenge02.application.usecases;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.grupo27.techchallenge02.Domain.enums.Categoria;
import br.com.grupo27.techchallenge02.Domain.model.Produto;
import br.com.grupo27.techchallenge02.application.config.mappers.ProdutoMapper;
import br.com.grupo27.techchallenge02.application.dto.ProdutoDTO;
import br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.repository.ProdutoRepositoryPort;
import br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.usecase.ProdutoService;

public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepositoryPort produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoServiceImpl(ProdutoRepositoryPort produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public ProdutoDTO createProduto(ProdutoDTO produtoDTO) {
        Produto produto = produtoDTO.toProduto();
        produto = produtoRepository.saveProduto(produto);
        return produtoMapper.domainToDto(produto);
    }

    @Override
    public ProdutoDTO updateProduto(Long id, ProdutoDTO produtoDTO) {
        Produto produto = produtoDTO.toProduto();
        produto = produtoRepository.updateProduto(id, produto);
        return produto != null ? produtoMapper.domainToDto(produto) : null;
    }

    @Override
    public ProdutoDTO getProdutoById(Long id) {
        Produto produto = produtoRepository.findProdutoById(id);
        return produto != null ? produtoMapper.domainToDto(produto) : null;
    }

    @Override
    public boolean deleteProduto(Long id) {
        return produtoRepository.deleteProduto(id);
    }

    @Override
    public List<ProdutoDTO> getAllProdutos() {
        return produtoRepository.listAllProdutos().stream()
                .map(produtoMapper::domainToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProdutoDTO> getProdutosByCategoria(Categoria categoria) {
        return produtoRepository.listByCategoria(categoria).stream()
                .map(produtoMapper::domainToDto)
                .collect(Collectors.toList());
    }
}