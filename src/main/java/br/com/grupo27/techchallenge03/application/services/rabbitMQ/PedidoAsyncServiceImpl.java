package br.com.grupo27.techchallenge03.application.services.rabbitMQ;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo27.techchallenge03.application.dto.CobrancaDTO;
import br.com.grupo27.techchallenge03.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge03.domain.interfaces.services.rabbitmq.PedidoAsyncService;

@Service
public class PedidoAsyncServiceImpl implements PedidoAsyncService {
    
    private static final Logger logger = LoggerFactory.getLogger(PedidoAsyncServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TopicExchange exchange;

    @Autowired
    private ObjectMapper objectMapper;

    public void enviarParafilaDePedidos(PedidoDTO pedido) {
        try {
            rabbitTemplate.convertAndSend(exchange.getName(), "pedido.novo", pedido);
            logger.info("Novo pedido encaminhado para fila de pedidos! ");
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public void enviarParafilaPagamentos(CobrancaDTO cobrancaDTO) {
        try {
            rabbitTemplate.convertAndSend(exchange.getName(), "pagamento.novo", cobrancaDTO);
            logger.info("Novo pedido encaminhado para fila de pagamentos! ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 public void enviarParafilaProducao(PedidoDTO pedido) {
        try {
            // Cria um Map para incluir o pedido e um id
            Map<String, Object> messagePayload = new HashMap<>();
            messagePayload.put("id", UUID.randomUUID().toString()); // Gera um id único para cada mensagem
            messagePayload.put("data", pedido); // Inclui os dados do pedido

            // Serializa o Map para JSON
            String jsonPayload = objectMapper.writeValueAsString(messagePayload);

            // Envia a mensagem serializada para a fila
            rabbitTemplate.convertAndSend("", "producaoQueue", jsonPayload);
            logger.info("Novo pedido encaminhado diretamente para a fila de producao!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
