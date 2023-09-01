package br.com.grupo27.techchallenge02.adapters.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.grupo27.techchallenge02.adapters.interfaces.usecase.PagamentoUsecase;
import br.com.grupo27.techchallenge02.application.dto.PedidoDTO;

@Controller
public class PagamentoController {

    private final PagamentoUsecase pagamentoUsecase;

    public PagamentoController(PagamentoUsecase pagamentoUsecase) {
        this.pagamentoUsecase = pagamentoUsecase;
    }

    public ResponseEntity<Boolean> verificaPagamento(@PathVariable Long id) {
        try {
            PedidoDTO pedidoAtualizado = pagamentoUsecase.verificaStatusPagamento(id);
            if (pedidoAtualizado != null) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.ok(false);
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

    public ResponseEntity<List<PedidoDTO>> getPedidosByStatusPagamento(@RequestParam boolean pago) {
        try {
            List<PedidoDTO> pedidos = pagamentoUsecase.findPedidosByStatusPagamento(pago);
            if (pedidos != null && !pedidos.isEmpty()) {
                return ResponseEntity.ok(pedidos);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
