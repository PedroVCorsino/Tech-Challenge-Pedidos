package br.com.grupo27.techchallenge03.application.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo27.techchallenge03.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge03.domain.interfaces.services.rabbitmq.PedidoAsyncService;

@Service
public class PedidoAsyncServiceImpl implements PedidoAsyncService {
    
    private static final Logger logger = LoggerFactory.getLogger(PedidoAsyncServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TopicExchange exchange;

    public void enviarParafilaDePedidos(PedidoDTO pedido) {
        try {
            rabbitTemplate.convertAndSend(exchange.getName(), "pedido.novo", pedido);
            logger.info("Novo pedido encaminhado para fila de pedidos! ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enviarParafilaPagamentos(PedidoDTO pedido) {
        try {
            rabbitTemplate.convertAndSend(exchange.getName(), "pagamento.novo", pedido);
            logger.info("Novo pedido encaminhado para fila de pagamentos! ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
