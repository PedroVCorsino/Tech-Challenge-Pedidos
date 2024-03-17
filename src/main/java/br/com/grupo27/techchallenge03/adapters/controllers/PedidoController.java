package br.com.grupo27.techchallenge03.adapters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.grupo27.techchallenge03.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge03.domain.enums.StatusPedido;
import br.com.grupo27.techchallenge03.domain.interfaces.services.rabbitmq.PedidoAsyncService;
import br.com.grupo27.techchallenge03.domain.interfaces.usecase.PedidoUseCase;
import br.com.grupo27.techchallenge03.domain.model.Pedido;

import java.util.List;
import java.util.Map;

@Controller
public class PedidoController {

    private final PedidoUseCase pedidoUseCase;

    private final PedidoAsyncService pedidoService;

    public PedidoController(PedidoUseCase pedidoUseCase, PedidoAsyncService pedidoService) {
        this.pedidoUseCase = pedidoUseCase;
        this.pedidoService = pedidoService;
    }

    public ResponseEntity<?> createPedido(@RequestBody PedidoDTO pedidoDTO) {
        pedidoService.enviarParafilaDePedidos(pedidoDTO);
        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .body(Map.of("mensagem", "Pedido enviado com sucesso"));
    }

    public ResponseEntity<PedidoDTO> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        try {
            PedidoDTO updatedPedido = pedidoUseCase.updatePedido(id, pedidoDTO);
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
            PedidoDTO pedido = pedidoUseCase.getPedidoById(id);
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
            boolean deleted = pedidoUseCase.deletePedido(id);
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
        List<PedidoDTO> pedidos = pedidoUseCase.getAllPedidos();
        return ResponseEntity.ok(pedidos);
    }

    public ResponseEntity<List<Pedido>> getPedidosByStatus(@PathVariable StatusPedido status) {
        try {
            List<Pedido> pedidos = pedidoUseCase.findPedidosByStatus(status);
            if (!pedidos.isEmpty()) {
                return ResponseEntity.ok(pedidos);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<PedidoDTO>> getPedidosAtivos() {
        try {
            List<PedidoDTO> pedidos = pedidoUseCase.findPedidosAtivos();
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
