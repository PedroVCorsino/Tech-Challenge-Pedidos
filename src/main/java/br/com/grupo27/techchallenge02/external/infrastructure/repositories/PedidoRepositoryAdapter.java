package br.com.grupo27.techchallenge02.external.infrastructure.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.grupo27.techchallenge02.Domain.enums.StatusPedido;
import br.com.grupo27.techchallenge02.Domain.model.Pedido;
import br.com.grupo27.techchallenge02.application.config.mappers.PedidoMapper;
import br.com.grupo27.techchallenge02.external.infrastructure.dataBaseEntities.PedidoEntity;
import br.com.grupo27.techchallenge02.external.infrastructure.repositories.JPA.PedidoJPA;
import br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.repository.PedidoRepositoryPort;

@Repository
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    private final PedidoJPA pedidoJPA;
    private final PedidoMapper pedidoMapper; // Instância do Mapper

    public PedidoRepositoryAdapter(PedidoJPA pedidoJPA, PedidoMapper pedidoMapper) {
        this.pedidoJPA = pedidoJPA;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    public Pedido findPedidoById(Long id) {
        return pedidoJPA.findById(id)
                .map(pedidoMapper::entityToDomain)
                .orElse(null);
    }

    @Override
    public List<Pedido> findAllPedidos() {
        List<PedidoEntity> pedidoEntities = pedidoJPA.findAll();
        return pedidoEntities.stream()
                .map(pedidoMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Pedido createPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoMapper.domainToEntity(pedido);
        PedidoEntity savedPedidoEntity = pedidoJPA.save(pedidoEntity);
        return pedidoMapper.entityToDomain(savedPedidoEntity);
    }

    @Override
    public Pedido updatePedido(Long id, Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoMapper.domainToEntity(pedido);
        PedidoEntity savedPedidoEntity = pedidoJPA.save(pedidoEntity);
        return pedidoMapper.entityToDomain(savedPedidoEntity);
    }

    @Override
    public boolean deletePedido(Long id) {
        pedidoJPA.deleteById(id);
        return true;
    }

    @Override
    public List<Pedido> findPedidosByStatusPagamento(boolean pago) {
        List<PedidoEntity> pedidoEntities = pedidoJPA.findByPago(pago);
        return pedidoEntities.stream()
            .map(pedidoMapper::entityToDomain)
            .collect(Collectors.toList());
    } 

    @Override
    public List<Pedido> findPedidosByStatus(StatusPedido status) {
        List<PedidoEntity> pedidoEntities = pedidoJPA.findByStatus(status);
        return pedidoEntities.stream()
            .map(pedidoMapper::entityToDomain)
            .collect(Collectors.toList());
    }
}
