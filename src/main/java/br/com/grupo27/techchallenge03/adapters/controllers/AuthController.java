package br.com.grupo27.techchallenge03.adapters.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.grupo27.techchallenge03.application.dto.UserDTO;
import br.com.grupo27.techchallenge03.domain.interfaces.services.AuthService;


@Controller
public class AuthController {
    
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public ResponseEntity<String>  authenticate(@RequestBody UserDTO userDTO) {
        return authService.authenticate(userDTO);
    }
}
