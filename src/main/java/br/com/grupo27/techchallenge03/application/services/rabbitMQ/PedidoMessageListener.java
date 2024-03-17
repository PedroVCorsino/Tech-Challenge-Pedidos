package br.com.grupo27.techchallenge03.application.services.rabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo27.techchallenge03.application.dto.CobrancaDTO;
import br.com.grupo27.techchallenge03.application.dto.PagamentoDTO;
import br.com.grupo27.techchallenge03.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge03.domain.interfaces.services.rabbitmq.PedidoAsyncService;
import br.com.grupo27.techchallenge03.domain.interfaces.usecase.PedidoUseCase;

@Service
public class PedidoMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(PedidoMessageListener.class);

    @Autowired
    private PedidoUseCase pedidoUseCase;

    @Autowired
    PedidoAsyncService pedidoAsyncService;

    @RabbitListener(queues = "pedidoQueue")
    public void receberPedido(PedidoDTO pedidoDTO) {
        try {
            logger.info("Novo pedido recebido!");
            PedidoDTO pedidoCriado = pedidoUseCase.createPedido(pedidoDTO);
            logger.info("Pedido Nro:{} criado.", pedidoCriado.id());

            CobrancaDTO cobrancaDTO =  new CobrancaDTO(
                pedidoCriado.id(), 
                pedidoCriado.idCliente().toString(), 
                pedidoCriado.valorTotal().toString());

            pedidoAsyncService.enviarParafilaPagamentos(cobrancaDTO);
            pedidoAsyncService.enviarParafilaProducao(pedidoCriado);

        } catch (Exception e) {
            logger.info("Erro ao registrar pedido ", e);
        }
    }

    @RabbitListener(queues = "pedidoQueue")
    public void receberPedidoPago(PagamentoDTO pagamentoDTO) {
        try {
            logger.info("Pedido Nro:{} pago!");
          
            PedidoDTO pedidoPago = pedidoUseCase.setStatusPago(pagamentoDTO.idPedido());

            pedidoAsyncService.enviarParafilaProducao(pedidoPago);
        } catch (Exception e) {
            logger.info("Erro ao registrar pedido ", e);
        }
    }
}
