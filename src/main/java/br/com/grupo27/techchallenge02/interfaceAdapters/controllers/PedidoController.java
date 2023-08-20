package br.com.grupo27.techchallenge02.interfaceAdapters.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.grupo27.techchallenge02.Domain.enums.StatusPedido;
import br.com.grupo27.techchallenge02.Domain.model.Pedido;
import br.com.grupo27.techchallenge02.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.usecase.PedidoService;

import java.util.List;

@Controller
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public ResponseEntity<PedidoDTO> createPedido(@RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO createdPedido = pedidoService.createPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPedido);
    }

    public ResponseEntity<PedidoDTO> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        try {
            PedidoDTO updatedPedido = pedidoService.updatePedido(id, pedidoDTO);
            if (updatedPedido != null) {
                return ResponseEntity.ok(updatedPedido);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable Long id) {
        try {
            PedidoDTO pedido = pedidoService.getPedidoById(id);
            if (pedido != null) {
                return ResponseEntity.ok(pedido);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        try {
            boolean deleted = pedidoService.deletePedido(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<PedidoDTO>> getAllPedidos() {
        List<PedidoDTO> pedidos = pedidoService.getAllPedidos();
        return ResponseEntity.ok(pedidos);
    }

    public ResponseEntity<Boolean> verificaPagamento(@PathVariable Long id) {
        try {
            PedidoDTO pedidoAtualizado = pedidoService.verificaStatusPagamento(id);
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
            List<PedidoDTO> pedidos = pedidoService.findPedidosByStatusPagamento(pago);
            if (pedidos != null && !pedidos.isEmpty()) {
                return ResponseEntity.ok(pedidos);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<Pedido>> getPedidosByStatus(@PathVariable StatusPedido status) {
        try {
            List<Pedido> pedidos = pedidoService.findPedidosByStatus(status);
            if (!pedidos.isEmpty()) {
                return ResponseEntity.ok(pedidos);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
