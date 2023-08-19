package br.com.grupo27.techchallenge02.application.dto;

import br.com.grupo27.techchallenge02.core.entities.model.Cliente;
import br.com.grupo27.techchallenge02.core.valuesObjects.ValidadorCPF;

public record ClienteDTO(Long id, ValidadorCPF cpf, String nome, String email) {
    public Cliente toCliente() {
        return new Cliente(this.id, this.cpf, this.nome, this.email);
    }
}