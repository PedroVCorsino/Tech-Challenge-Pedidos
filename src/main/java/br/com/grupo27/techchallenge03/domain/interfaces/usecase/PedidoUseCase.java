package br.com.grupo27.techchallenge03.domain.interfaces.usecase;

import java.util.List;

import br.com.grupo27.techchallenge03.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge03.domain.enums.StatusPedido;
import br.com.grupo27.techchallenge03.domain.model.Pedido;

public interface PedidoUseCase {

    PedidoDTO getPedidoById(Long id);

    List<PedidoDTO> getAllPedidos();

    PedidoDTO createPedido(PedidoDTO pedidoDTO);

    PedidoDTO updatePedido(Long id, PedidoDTO pedidoDTO);

    boolean deletePedido(Long id);

    List<Pedido> findPedidosByStatus(StatusPedido status);

    List<PedidoDTO> findPedidosAtivos();

    PedidoDTO setStatusPago(Long idPedido);
    
}
