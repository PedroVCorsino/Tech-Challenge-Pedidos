package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.repository;

import java.util.List;

import br.com.grupo27.techchallenge02.Domain.enums.StatusPedido;
import br.com.grupo27.techchallenge02.Domain.model.Pedido;

public interface PedidoRepositoryPort {

    Pedido findPedidoById(Long id);

    List<Pedido> findAllPedidos();

    Pedido createPedido(Pedido pedido);

    Pedido updatePedido(Long id, Pedido pedido);

    boolean deletePedido(Long id);

    List<Pedido> findPedidosByStatusPagamento(boolean pago);

    List<Pedido> findPedidosByStatus(StatusPedido status);
    
}
