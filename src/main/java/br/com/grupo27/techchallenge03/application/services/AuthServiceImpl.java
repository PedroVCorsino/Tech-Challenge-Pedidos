package br.com.grupo27.techchallenge03.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.grupo27.techchallenge03.application.dto.UserDTO;
import br.com.grupo27.techchallenge03.domain.interfaces.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "https://i45cg2jrd2.execute-api.us-east-1.amazonaws.com/Prod";
    
    @Override
    public ResponseEntity<String> authenticate(UserDTO userDTO) {
        
        // Configura o HttpHeaders para definir o tipo de conteúdo como application/json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        // Envolva o DTO em uma HttpEntity junto com os cabeçalhos
        HttpEntity<UserDTO> requestEntity = new HttpEntity<>(userDTO, headers);
        
        // Faça a solicitação POST usando o RestTemplate com a HttpEntity criada
        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL + "/auth", requestEntity, String.class);
        return response;
    }
}
