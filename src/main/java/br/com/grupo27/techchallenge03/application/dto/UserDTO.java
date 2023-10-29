package br.com.grupo27.techchallenge03.application.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserDTO(
    @NotEmpty(message = "CPF não pode ser vazio.")
    @Size(min = 11, max = 11, message = "CPF deve conter 11 dígitos.")
    String username,

    @NotEmpty(message = "Senha não pode ser vazia.")
    String password
) {}
