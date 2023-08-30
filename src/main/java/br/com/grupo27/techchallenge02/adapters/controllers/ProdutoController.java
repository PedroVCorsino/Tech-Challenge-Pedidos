package br.com.grupo27.techchallenge02.adapters.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.grupo27.techchallenge02.adapters.interfaces.usecase.ProdutoUseCase;
import br.com.grupo27.techchallenge02.application.dto.ProdutoDTO;
import br.com.grupo27.techchallenge02.domain.enums.Categoria;

import java.util.List;

@Controller
public class ProdutoController {

    private final ProdutoUseCase produtoService;

    public ProdutoController(ProdutoUseCase produtoService) {
        this.produtoService = produtoService;
    }

    public ResponseEntity<ProdutoDTO> createProduto(ProdutoDTO produtoDTO) {
        ProdutoDTO createdProduto = produtoService.createProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduto);
    }

    public ResponseEntity<ProdutoDTO> updateProduto(Long id, ProdutoDTO produtoDTO) {
        try {
            ProdutoDTO updatedProduto = produtoService.updateProduto(id, produtoDTO);
            if (updatedProduto != null) {
                return ResponseEntity.ok(updatedProduto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<ProdutoDTO> getProdutoById(Long id) {
        try {
            ProdutoDTO produto = produtoService.getProdutoById(id);
            if (produto != null) {
                return ResponseEntity.ok(produto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<Void> deleteProduto(Long id) {
        try {
            boolean deleted = produtoService.deleteProduto(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {
        List<ProdutoDTO> produtos = produtoService.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    public ResponseEntity<List<ProdutoDTO>> getProdutosByCategoria(Categoria tipo) {
        List<ProdutoDTO> produtos = produtoService.getProdutosByCategoria(tipo);
        return ResponseEntity.ok(produtos);
    }
}
