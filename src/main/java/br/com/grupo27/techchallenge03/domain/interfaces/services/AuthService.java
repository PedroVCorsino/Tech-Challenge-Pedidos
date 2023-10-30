package br.com.grupo27.techchallenge03.domain.interfaces.services;

import org.springframework.http.ResponseEntity;
import br.com.grupo27.techchallenge03.application.dto.UserDTO;

public interface AuthService {
     ResponseEntity<String>  authenticate(UserDTO userDTO);
}
