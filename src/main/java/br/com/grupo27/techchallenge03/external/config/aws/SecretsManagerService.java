package br.com.grupo27.techchallenge03.external.config.aws;

import org.springframework.stereotype.Service;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@Service
public class SecretsManagerService {

    public String getSecretValue(String secretName) {
        Region region = Region.of("us-east-1");

        try (SecretsManagerClient client = SecretsManagerClient.builder()
                                                               .region(region)
                                                               .credentialsProvider(DefaultCredentialsProvider.create())
                                                               .build()) {
            GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                                                                               .secretId(secretName)
                                                                               .build();
            GetSecretValueResponse getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
            return getSecretValueResponse.secretString();
        }
    }
}
