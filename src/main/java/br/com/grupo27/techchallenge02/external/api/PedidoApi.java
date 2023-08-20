package br.com.grupo27.techchallenge02.external.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.grupo27.techchallenge02.Domain.enums.StatusPedido;
import br.com.grupo27.techchallenge02.Domain.model.Pedido;
import br.com.grupo27.techchallenge02.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge02.interfaceAdapters.controllers.PedidoController;

import java.util.List;

@RestController
@RequestMapping("api/pedido")
public class PedidoApi {

    private final PedidoController controller;

    public PedidoApi(PedidoController controller) {
        this.controller = controller;
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> createPedido(@RequestBody PedidoDTO pedidoDTO) {
        return controller.createPedido(pedidoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        return controller.updatePedido(id, pedidoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable Long id) {
        return controller.getPedidoById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        return controller.deletePedido(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PedidoDTO>> getAllPedidos() {
        return controller.getAllPedidos();
    }

    @GetMapping("/verifica-pagamento/{id}")
    public ResponseEntity<Boolean> verificaPagamento(@PathVariable Long id) {
        return controller.verificaPagamento(id);
    }


    @GetMapping("/status-pagamento")
    public ResponseEntity<List<PedidoDTO>> getPedidosByStatusPagamento(@RequestParam boolean pago) {
        return controller.getPedidosByStatusPagamento(pago);
    }

   @GetMapping("/status/{status}")
    public ResponseEntity<List<Pedido>> getPedidosByStatus(@PathVariable StatusPedido status) {
        return controller.getPedidosByStatus(status);
    }
}
