package br.com.grupo27.techchallenge02.application.usecases;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.grupo27.techchallenge02.adapters.interfaces.client.PagamentosClient;
import br.com.grupo27.techchallenge02.adapters.interfaces.usecase.PedidoUseCase;
import br.com.grupo27.techchallenge02.adapters.mappers.PedidoMapper;
import br.com.grupo27.techchallenge02.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge02.domain.enums.StatusPedido;
import br.com.grupo27.techchallenge02.domain.model.Pedido;
import br.com.grupo27.techchallenge02.external.infrastructure.repositories.PedidoGatewayImpl;

public class PedidoUseCaseImpl implements PedidoUseCase {

    private final PedidoGatewayImpl pedidoAdapter;
    private final PedidoMapper pedidoMapper;
    private final PagamentosClient pagamentosClient;
    
    private static final Logger logger = LoggerFactory.getLogger(PedidoUseCaseImpl.class);

    public PedidoUseCaseImpl(PedidoGatewayImpl pedidoAdapter,
        PedidoMapper pedidoMapper, PagamentosClient pagamentosClient) {
        this.pedidoAdapter = pedidoAdapter;
        this.pedidoMapper = pedidoMapper;
        this.pagamentosClient = pagamentosClient;
    }

    @Override
    public PedidoDTO getPedidoById(Long id) {
        Pedido pedido = pedidoAdapter.findPedidoById(id);
        return pedidoMapper.domainToDto(pedido);
    }

    @Override
    public List<PedidoDTO> getAllPedidos() {
        List<Pedido> pedidos = pedidoAdapter.findAllPedidos();
        return pedidos.stream().map(pedidoMapper::domainToDto).collect(Collectors.toList());
    }

    @Override
    public PedidoDTO createPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.dtoToDomain(pedidoDTO);
        Pedido createdPedido = pedidoAdapter.createPedido(pedido);
        return pedidoMapper.domainToDto(createdPedido);
    }

    @Override
    public PedidoDTO updatePedido(Long id, PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.dtoToDomain(pedidoDTO);
        Pedido updatedPedido = pedidoAdapter.updatePedido(id, pedido);
        return pedidoMapper.domainToDto(updatedPedido);
    }

    @Override
    public boolean deletePedido(Long id) {
        return pedidoAdapter.deletePedido(id);
    }
    
    @Override
    public List<Pedido> findPedidosByStatus(StatusPedido status) {
        return pedidoAdapter.findPedidosByStatus(status);
    }
}
