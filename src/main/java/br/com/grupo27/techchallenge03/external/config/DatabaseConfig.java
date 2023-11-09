package br.com.grupo27.techchallenge03.external.config;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.grupo27.techchallenge03.application.usecases.PagamentoUseCaseImpl;
import br.com.grupo27.techchallenge03.external.config.aws.SecretsManagerService;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    private final SecretsManagerService secretsManagerService;

    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

    public DatabaseConfig(SecretsManagerService secretsManagerService) {
        this.secretsManagerService = secretsManagerService;
    }

    @Bean
    public DataSource dataSource(DataSourceProperties properties) {
        String secretJson = secretsManagerService.getSecretValue("db/postrgres");
        
        logger.info("Secret json: {} //",secretJson);

        JSONObject secret = new JSONObject(secretJson);

        String username = secret.getString("username");
        String password = secret.getString("password");
        String host = secret.getString("host");
        String dbname = secret.getString("dbname");
        int port = secret.getInt("port");

        String jdbcUrl = String.format("jdbc:postgresql://%s:%d/%s", host, port, dbname);

        logger.info("jdbcUrl: {} //",jdbcUrl);

        // Aqui, você retornamos o DataSource construído com o jdbcUrl, username e password
        return DataSourceBuilder.create()
        .url(jdbcUrl) // Use a variável jdbcUrl que você criou
        .username(username)
        .password(password)
        .driverClassName("org.postgresql.Driver") // Adicione explicitamente o driver
        .build();

    }
}
