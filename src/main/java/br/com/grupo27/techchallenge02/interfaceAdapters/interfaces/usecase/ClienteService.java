package br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.usecase;

import java.util.List;

import br.com.grupo27.techchallenge02.application.dto.ClienteDTO;
import br.com.grupo27.techchallenge02.core.valuesObjects.ValidadorCPF;

public interface ClienteService {

    ClienteDTO getClienteById(Long id);

    List<ClienteDTO> getAllClientes();

    ClienteDTO createCliente(ClienteDTO clienteDTO);

    ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO);

    boolean deleteCliente(Long id);

    ClienteDTO getClienteByCPF(String cpf);
    
}