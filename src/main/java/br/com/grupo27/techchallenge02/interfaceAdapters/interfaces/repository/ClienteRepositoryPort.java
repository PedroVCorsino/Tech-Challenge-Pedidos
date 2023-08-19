package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.repository;

import java.util.List;

import br.com.grupo27.techchallenge02.core.entities.model.Cliente;
import br.com.grupo27.techchallenge02.core.valuesObjects.ValidadorCPF;

public interface ClienteRepositoryPort {
    Cliente saveCliente(Cliente clienteDTO);
    Cliente updateCliente(Long id, Cliente clienteDTO);
    Cliente findById(Long id);
    boolean deleteCliente(Long id);
    List<Cliente> listAllClientes();
    Cliente findByCpf(ValidadorCPF cpf);
}