package br.com.grupo27.techchallenge02.adapters.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.grupo27.techchallenge02.adapters.interfaces.usecase.ClienteUseCase;
import br.com.grupo27.techchallenge02.application.dto.ClienteDTO;

import java.util.List;

@Controller
public class ClienteController {

    private final ClienteUseCase clienteService;

    public ClienteController(ClienteUseCase clienteService) {
        this.clienteService = clienteService;
    }

    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO createdCliente = clienteService.createCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCliente);
    }

    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        try {
            ClienteDTO updatedCliente = clienteService.updateCliente(id, clienteDTO);
            if (updatedCliente != null) {
                return ResponseEntity.ok(updatedCliente);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id) {
        try {
            ClienteDTO cliente = clienteService.getClienteById(id);
            if (cliente != null) {
                return ResponseEntity.ok(cliente);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        try {
            boolean deleted = clienteService.deleteCliente(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<ClienteDTO>> getAllClientes() {
        List<ClienteDTO> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    public ResponseEntity<ClienteDTO> getClienteByCpf(@PathVariable String cpf) {
        try {
            ClienteDTO cliente = clienteService.getClienteByCPF(cpf);
            if (cliente != null) {
                return ResponseEntity.ok(cliente);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}