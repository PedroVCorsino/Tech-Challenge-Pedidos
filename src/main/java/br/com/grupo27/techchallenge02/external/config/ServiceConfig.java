package br.com.grupo27.techchallenge02.external.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.grupo27.techchallenge02.adapters.gateways.ClienteGateway;
import br.com.grupo27.techchallenge02.adapters.gateways.ProdutoGateway;
import br.com.grupo27.techchallenge02.adapters.interfaces.client.PagamentosClient;
import br.com.grupo27.techchallenge02.adapters.interfaces.usecase.PedidoUseCase;
import br.com.grupo27.techchallenge02.adapters.mappers.PedidoMapper;
import br.com.grupo27.techchallenge02.adapters.mappers.ProdutoMapper;
import br.com.grupo27.techchallenge02.application.clients.PagamentosClientImpl;
import br.com.grupo27.techchallenge02.application.usecases.ClienteUseCaseImpl;
import br.com.grupo27.techchallenge02.application.usecases.PagamentoUseCaseImpl;
import br.com.grupo27.techchallenge02.application.usecases.PedidoUseCaseImpl;
import br.com.grupo27.techchallenge02.application.usecases.ProdutoUseCaseImpl;
import br.com.grupo27.techchallenge02.external.infrastructure.repositories.PedidoGatewayImpl;
import br.com.grupo27.techchallenge02.external.infrastructure.repositories.JPA.PedidoJPA;

@Configuration
public class ServiceConfig {

    @Bean
    public PedidoUseCaseImpl pedidoUseCase(PedidoJPA pedidoJPA, PedidoMapper pedidoMapper, PagamentosClient pagamentosClient) {
        return new PedidoUseCaseImpl(new PedidoGatewayImpl(pedidoJPA, pedidoMapper), pedidoMapper, pagamentosClient);
    }

    @Bean
    public PagamentosClient pagamentosClient(WebClient.Builder webClientBuilder) {
        return new PagamentosClientImpl(webClientBuilder);
    }

    @Bean
    public ClienteUseCaseImpl clienteUseCase(ClienteGateway clienteRepository) {
        return new ClienteUseCaseImpl(clienteRepository);
    }

    @Bean
    public ProdutoUseCaseImpl produtoUseCase(ProdutoGateway produtoRepository, ProdutoMapper produtoMapper) {
        return new ProdutoUseCaseImpl(produtoRepository, produtoMapper);
    }

    @Bean PagamentoUseCaseImpl pagamentoUseCase(PedidoGatewayImpl pedidoAdapter, PedidoMapper pedidoMapper,
            PagamentosClient pagamentosClient, PedidoUseCase pedidoUseCase){
        return new PagamentoUseCaseImpl(pedidoAdapter, pedidoMapper, pagamentosClient, pedidoUseCase);
    }
}
