package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.usecase;

import java.util.List;

import br.com.grupo27.techchallenge02.Domain.valuesObjects.ValidadorCPF;
import br.com.grupo27.techchallenge02.application.dto.ClienteDTO;

public interface ClienteService {

    ClienteDTO getClienteById(Long id);

    List<ClienteDTO> getAllClientes();

    ClienteDTO createCliente(ClienteDTO clienteDTO);

    ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO);

    boolean deleteCliente(Long id);

    ClienteDTO getClienteByCPF(String cpf);
    
}