package br.com.grupo27.techchallenge02.adapters.interfaces.usecase;

import java.util.List;

import br.com.grupo27.techchallenge02.application.dto.PedidoDTO;

public interface PagamentoUsecase {
    
    boolean consultaStatusPagamento(Long id);

    PedidoDTO verificaStatusPagamento(Long id);

    List<PedidoDTO> findPedidosByStatusPagamento(boolean pago);
}
