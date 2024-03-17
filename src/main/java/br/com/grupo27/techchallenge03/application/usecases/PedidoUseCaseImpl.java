package br.com.grupo27.techchallenge03.application.usecases;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.grupo27.techchallenge03.adapters.gateways.ClienteGateway;
import br.com.grupo27.techchallenge03.adapters.mappers.PedidoMapper;
import br.com.grupo27.techchallenge03.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge03.domain.enums.StatusPedido;
import br.com.grupo27.techchallenge03.domain.interfaces.usecase.PedidoUseCase;
import br.com.grupo27.techchallenge03.domain.model.Cliente;
import br.com.grupo27.techchallenge03.domain.model.Pedido;
import br.com.grupo27.techchallenge03.external.infrastructure.repositories.PedidoGatewayImpl;

public class PedidoUseCaseImpl implements PedidoUseCase {

    private final PedidoGatewayImpl pedidoGateway;
    private final PedidoMapper pedidoMapper;
    private final ClienteGateway clienteGateway;
    
    private static final Logger logger = LoggerFactory.getLogger(PedidoUseCaseImpl.class);

    

    public PedidoUseCaseImpl(PedidoGatewayImpl pedidoGateway, PedidoMapper pedidoMapper, ClienteGateway clienteGateway) {
        this.pedidoGateway = pedidoGateway;
        this.pedidoMapper = pedidoMapper;
        this.clienteGateway = clienteGateway;
    }

    @Override
    public PedidoDTO getPedidoById(Long id) {
        Pedido pedido = pedidoGateway.findPedidoById(id);
        return pedidoMapper.domainToDto(pedido);
    }

    @Override
    public List<PedidoDTO> getAllPedidos() {
        List<Pedido> pedidos = pedidoGateway.findAllPedidos();
        return pedidos.stream().map(pedidoMapper::domainToDto).collect(Collectors.toList());
    }

    @Override
    public PedidoDTO createPedido(PedidoDTO pedidoDTO) {
        Cliente cliente = clienteGateway.findById(pedidoDTO.idCliente());
        Pedido pedido = pedidoMapper.dtoToDomain(pedidoDTO);
        Pedido createdPedido = pedidoGateway.createPedido(pedido);
        PedidoDTO pedidoSalvo = pedidoMapper.domainToDto(createdPedido);
        return pedidoSalvo;
    }

    @Override
    public PedidoDTO updatePedido(Long id, PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.dtoToDomain(pedidoDTO);
        Pedido updatedPedido = pedidoGateway.updatePedido(id, pedido);
        return pedidoMapper.domainToDto(updatedPedido);
    }

    @Override
    public boolean deletePedido(Long id) {
        return pedidoGateway.deletePedido(id);
    }
    
    @Override
    public List<Pedido> findPedidosByStatus(StatusPedido status) {
        return pedidoGateway.findPedidosByStatus(status);
    }

    @Override
    public List<PedidoDTO> findPedidosAtivos(){
        List<Pedido> pedidos = pedidoGateway.findPedidosAtivos();
        return pedidos.stream().map(pedidoMapper::domainToDto).collect(Collectors.toList());
    }

    @Override
    public PedidoDTO setStatusPago(Long idPedido) {
        Pedido pedido = pedidoMapper.dtoToDomain(this.getPedidoById(idPedido));
        pedido.setPago(true);
        pedido.setStatus(StatusPedido.RECEBIDO);
        return this.updatePedido(idPedido,  pedidoMapper.domainToDto(pedido));
    }

}
