package br.com.grupo27.techchallenge03.domain.interfaces.usecase;

import java.util.List;

import br.com.grupo27.techchallenge03.application.dto.ClienteDTO;
import br.com.grupo27.techchallenge03.domain.valuesObjects.ValidadorCPF;

public interface ClienteUseCase {

    ClienteDTO getClienteById(Long id);

    List<ClienteDTO> getAllClientes();

    ClienteDTO createCliente(ClienteDTO clienteDTO);

    ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO);

    boolean deleteCliente(Long id);

    ClienteDTO getClienteByCPF(String cpf);
    
}