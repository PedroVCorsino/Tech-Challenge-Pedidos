package br.com.grupo27.techchallenge02.application.usecases;

import java.util.List;
import java.util.stream.Collectors;

import br.com.grupo27.techchallenge02.adapters.interfaces.client.PagamentosClient;
import br.com.grupo27.techchallenge02.adapters.interfaces.usecase.PagamentoUsecase;
import br.com.grupo27.techchallenge02.adapters.interfaces.usecase.PedidoUseCase;
import br.com.grupo27.techchallenge02.adapters.mappers.PedidoMapper;
import br.com.grupo27.techchallenge02.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge02.domain.model.Pedido;
import br.com.grupo27.techchallenge02.external.infrastructure.repositories.PedidoGatewayImpl;

public class PagamentoUseCaseImpl implements PagamentoUsecase {

    private final PedidoGatewayImpl pedidoAdapter;
    private final PedidoMapper pedidoMapper;
    private final PagamentosClient pagamentosClient;
    private final PedidoUseCase pedidoUseCase;

    public PagamentoUseCaseImpl(PedidoGatewayImpl pedidoAdapter, PedidoMapper pedidoMapper,
            PagamentosClient pagamentosClient, PedidoUseCase pedidoUseCase) {
        this.pedidoAdapter = pedidoAdapter;
        this.pedidoMapper = pedidoMapper;
        this.pagamentosClient = pagamentosClient;
        this.pedidoUseCase = pedidoUseCase;
    }

    @Override
    public boolean consultaStatusPagamento(Long id) {
        return pagamentosClient.consultaStatusPagamento(id);
    }

    @Override
    public PedidoDTO verificaStatusPagamento(Long id) {
        PedidoDTO pedidoDto = pedidoUseCase.getPedidoById(id);

        if (pedidoDto == null) {
            throw new RuntimeException("Pedido não encontrado");
        }

        if (pedidoDto.pago()) {
            return pedidoDto;
        }

        boolean isPago = consultaStatusPagamento(id);

        if (isPago) {
            Pedido pedido = pedidoMapper.dtoToDomain(pedidoDto);
            pedido.setPago(true);
            return pedidoUseCase.updatePedido(id, pedidoDto);
        } else {
            throw new RuntimeException("Pedido não pago");
        }
    }

    @Override
    public List<PedidoDTO> findPedidosByStatusPagamento(boolean pago) {
        List<Pedido> pedidos = pedidoAdapter.findPedidosByStatusPagamento(pago);
        return pedidos.stream().map(pedidoMapper::domainToDto).collect(Collectors.toList());
    }

}
