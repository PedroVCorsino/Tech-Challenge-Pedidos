package br.com.grupo27.techchallenge03.domain.interfaces.services.rabbitmq;

import br.com.grupo27.techchallenge03.application.dto.CobrancaDTO;
import br.com.grupo27.techchallenge03.application.dto.PedidoDTO;

public interface PedidoAsyncService {
     public void enviarParafilaDePedidos(PedidoDTO pedido);

     public void enviarParafilaPagamentos(CobrancaDTO cobrancaDTO);

     public void enviarParafilaProducao(PedidoDTO pedido);
}
