package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.usecase;

import java.util.List;

import br.com.grupo27.techchallenge02.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge02.core.entities.model.Pedido;
import br.com.grupo27.techchallenge02.core.enums.StatusPedido;

public interface PedidoService {

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
