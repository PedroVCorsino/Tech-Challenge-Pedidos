package br.com.grupo27.techchallenge02.adapters.interfaces.usecase;

import java.util.List;

import br.com.grupo27.techchallenge02.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge02.domain.enums.StatusPedido;
import br.com.grupo27.techchallenge02.domain.model.Pedido;

public interface PedidoUseCase {

    PedidoDTO getPedidoById(Long id);

    List<PedidoDTO> getAllPedidos();

    PedidoDTO createPedido(PedidoDTO pedidoDTO);

    PedidoDTO updatePedido(Long id, PedidoDTO pedidoDTO);

    boolean deletePedido(Long id);

    boolean consultaStatusPagamento(Long id);

    PedidoDTO verificaStatusPagamento(Long id);

    List<PedidoDTO> findPedidosByStatusPagamento(boolean pago);

    List<Pedido> findPedidosByStatus(StatusPedido status);
    
}
