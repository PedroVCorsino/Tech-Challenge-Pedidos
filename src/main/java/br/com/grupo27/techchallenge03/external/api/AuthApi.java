package br.com.grupo27.techchallenge03.external.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.grupo27.techchallenge03.adapters.controllers.AuthController;
import br.com.grupo27.techchallenge03.application.dto.UserDTO;


@RestController
@RequestMapping("/public/auth")
public class AuthApi {
    
    private final AuthController authController;

    public AuthApi(AuthController authController) {
        this.authController = authController;
    }

    @PostMapping
    public ResponseEntity<String>  authenticate(@RequestBody UserDTO userDTO) {
        return authController.authenticate(userDTO);
    }
}
