# Tech-Challenge

Desafio desenvolvido para a fase04 do curso de Software Architecture da FIAP Pós Tech.

## Versão
2.2 [Dockerhub](https://hub.docker.com/repository/docker/pedrovcorsino/tech_challenge/tags "Go to Dockerhub")

## Tecnologias
<div style="display: inline_block"><br>
    <img align="center" alt="java" height="50" width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg">    
    <img align="center" alt="jspring" height="40" width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" />  
    <img align="center" alt="postgre" height="50" width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original-wordmark.svg">
    <img align="center" alt="kubernets" height="50" width="80" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/kubernetes/kubernetes-plain-wordmark.svg">  
</div>

## Escolha das tecnologias
### Linguagem
- Java
    - Java escolha estratégica para aplicações que demandam escalabilidade, robustez e alta performance. Java é uma linguagem robusta e eficiente, ideal para lidar com o crescimento e a complexidade de aplicações empresariais. Sua capacidade de gerenciar cargas pesadas e variadas de trabalho assegura uma base sólida para o backend.

### Framework
- SpringBoot
  - O Spring Boot, por sua vez, agiliza o desenvolvimento em Java, proporcionando uma plataforma coesa e flexível. Sua facilidade de uso e a vasta gama de funcionalidades integradas permitem um desenvolvimento ágil e eficiente, crucial para aplicações que precisam evoluir rapidamente.

### Repositorio de dados
- Postgres
    - O PostgreSQL é um banco de dados SQL de alto desempenho, conhecido pela sua capacidade de lidar com grandes volumes de dados e transações complexas com eficiência. Ele oferece escalabilidade e robustez, garantindo que as operações de dados sejam não apenas rápidas, mas também seguras e confiáveis.

Juntas, estas tecnologias formam um trio poderoso para desenvolver aplicações que não apenas atendem às demandas atuais, mas também estão preparadas para crescer e se adaptar às necessidades futuras, mantendo uma performance excepcional.




## Documentação do sistema (DDD) utilizando a linguagem ubíqua.
### Contextos delimitados
- Pedido (Realização do pedido e pagamento) 
  ![image](https://github.com/PedroVCorsino/Tech-Challenge/assets/61948860/0c627219-8fb8-4bdc-b88a-3d0db6087973)

### Domínios
- Subdomínio Principal:
    - Comida
- Subdomínio Genérico:
    - Lógica de pagamento integrada ao mercado pago.
- Subdomínio Suporte:
    - Gestão de estoque,
    - funcionários, clientes,
    - estratégias de marketing

### Dicionário de linguagem ubíqua
- Identificação: Pode se identificar usando CPF, nome, e-mail ou não se identificar.
- Produto: Quaisquer itens vendidos pela lanchonete, divididos nas categorias Lanche, Acompanhamento, Bebida e Sobremesa.
- Combo: É uma oferta especial que combina um lanche, um acompanhamento, uma bebida e uma sobremesa por um preço promocional.
- Lanche: Refere-se ao item principal do cardápio, geralmente um sanduíche ou hambúrguer, ou uma opção de refeição vegana.
 - Acompanhamento: É uma opção adicional que pode ser escolhida juntamente com o lanche. Pode incluir batatas fritas, nuggets, onion rings, salada, ou outras opções de acompanhamentos.
- Bebida: São as opções líquidas disponíveis para serem consumidas junto com o lanche. Isso pode incluir refrigerantes, sucos, água, chás gelados, milkshakes, entre outros.
- Sobremesa: Refere-se a um item do cardápio que é servido após a refeição principal. Pode incluir opções como sorvetes, tortas, bolos, milkshakes especiais ou outras delícias doces.
- Categoria: Ou tipo, se refere a qual tipo de produto entre as opções lanche, acompanhamento, bebida e sobremesa.
---
  

## Autores
- [Diego Amorim](https://github.com/dieg0amorim)
- [Gabriela Ribeiro](https://github.com/gabsribeiro)
- [Luzivan Gois](https://github.com/luzivanmgois)
- [Pedro Vinicius](https://github.com/PedroVCorsino)
