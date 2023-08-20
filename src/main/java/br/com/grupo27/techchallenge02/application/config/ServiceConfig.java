package br.com.grupo27.techchallenge02.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.grupo27.techchallenge02.application.clients.PagamentosClientImpl;
import br.com.grupo27.techchallenge02.application.config.mappers.PedidoMapper;
import br.com.grupo27.techchallenge02.application.config.mappers.ProdutoMapper;
import br.com.grupo27.techchallenge02.application.usecases.ClienteServiceImpl;
import br.com.grupo27.techchallenge02.application.usecases.PedidoServiceImpl;
import br.com.grupo27.techchallenge02.application.usecases.ProdutoServiceImpl;
import br.com.grupo27.techchallenge02.external.infrastructure.repositories.PedidoRepositoryAdapter;
import br.com.grupo27.techchallenge02.external.infrastructure.repositories.JPA.PedidoJPA;
import br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.client.PagamentosClient;
import br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.repository.ClienteRepositoryPort;
import br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.repository.ProdutoRepositoryPort;

@Configuration
public class ServiceConfig {

    @Bean
    public PedidoServiceImpl pedidoService(PedidoJPA pedidoJPA, PedidoMapper pedidoMapper, PagamentosClient pagamentosClient) {
        return new PedidoServiceImpl(new PedidoRepositoryAdapter(pedidoJPA, pedidoMapper), pedidoMapper, pagamentosClient);
    }

    @Bean
    public PagamentosClient pagamentosClient(WebClient.Builder webClientBuilder) {
        return new PagamentosClientImpl(webClientBuilder);
    }

    @Bean
    public ClienteServiceImpl clienteService(ClienteRepositoryPort clienteRepository) {
        return new ClienteServiceImpl(clienteRepository);
    }

    @Bean
    public ProdutoServiceImpl produtoService(ProdutoRepositoryPort produtoRepository, ProdutoMapper produtoMapper) {
        return new ProdutoServiceImpl(produtoRepository, produtoMapper);
    }

    
}
