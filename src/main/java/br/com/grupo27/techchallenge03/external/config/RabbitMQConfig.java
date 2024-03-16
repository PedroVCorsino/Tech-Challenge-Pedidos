package br.com.grupo27.techchallenge03.external.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // Configuração da fila de pedidos
    @Bean
    Queue pedidoQueue() {
        return new Queue("pedidoQueue", false);
    }

    // Adicionando a configuração da fila de pagamentos
    @Bean
    Queue pagamentoQueue() {
        return new Queue("pagamentoQueue", false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("pedidoExchange");
    }

    // Binding para a fila de pedidos
    @Bean
    Binding pedidoBinding(Queue pedidoQueue, TopicExchange exchange) {
        return BindingBuilder.bind(pedidoQueue).to(exchange).with("pedido.#");
    }

    // Adicionando um binding para a fila de pagamentos
    // Se a fila de pagamentos pode utilizar o mesmo padrão de roteamento ou necessita de um diferente, ajuste o argumento .with() conforme necessário
    @Bean
    Binding pagamentoBinding(Queue pagamentoQueue, TopicExchange exchange) {
        return BindingBuilder.bind(pagamentoQueue).to(exchange).with("pagamento.#");
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

}
