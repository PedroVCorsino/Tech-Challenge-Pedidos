package br.com.grupo27.techchallenge03.application.usecases;

import java.util.List;
import java.util.stream.Collectors;

import br.com.grupo27.techchallenge03.adapters.gateways.ClienteGateway;
import br.com.grupo27.techchallenge03.application.dto.ClienteDTO;
import br.com.grupo27.techchallenge03.domain.interfaces.usecase.ClienteUseCase;
import br.com.grupo27.techchallenge03.domain.model.Cliente;
import br.com.grupo27.techchallenge03.domain.valuesObjects.ValidadorCPF;

public class ClienteUseCaseImpl implements ClienteUseCase {

    private final ClienteGateway clienteRepository;

    public ClienteUseCaseImpl(ClienteGateway clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        String cpfString = clienteDTO.cpf().toString();
        if (!cpfString.isEmpty()) {
            ValidadorCPF cpf = new ValidadorCPF(cpfString);
            Cliente clienteExistente = clienteRepository.findByCpf(cpf);
            if (clienteExistente != null) {
                throw new IllegalArgumentException("O CPF já está cadastrado.");
            }
        }

        Cliente cliente = clienteDTO.toCliente();
        cliente = clienteRepository.saveCliente(cliente);
        return cliente.toDTO();
    }

    @Override
    public ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO) {
        String cpfString = clienteDTO.cpf().toString();
        if (!cpfString.isEmpty()) {
            ValidadorCPF cpf = new ValidadorCPF(cpfString);
            Cliente clienteExistente = clienteRepository.findByCpf(cpf);
            if (clienteExistente != null && !clienteExistente.getId().equals(id)) {
                throw new IllegalArgumentException("O CPF já está cadastrado para outro cliente.");
            }
        }

        Cliente cliente = clienteDTO.toCliente();
        cliente = clienteRepository.updateCliente(id, cliente);
        return cliente != null ? cliente.toDTO() : null;
    }



    @Override
    public ClienteDTO getClienteById(Long id) {
        Cliente cliente = clienteRepository.findById(id);
        return cliente != null ? cliente.toDTO() : null;
    }

    @Override
    public boolean deleteCliente(Long id) {
        return clienteRepository.deleteCliente(id);
    }

    @Override
    public List<ClienteDTO> getAllClientes() {
        return clienteRepository.listAllClientes().stream()
                .map(Cliente::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO getClienteByCPF(String cpfString) throws IllegalArgumentException {
        if (cpfString.isEmpty()) {
            throw new IllegalArgumentException("O CPF não pode ser vazio.");
        }

        try {
            ValidadorCPF cpf = new ValidadorCPF(cpfString);
            Cliente cliente = clienteRepository.findByCpf(cpf);
            return cliente != null ? cliente.toDTO() : null;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @Override
    public boolean solicitarRemocaoDeDados(String cpf) {
        try {
            ClienteDTO clienteDTO = this.getClienteByCPF(cpf);
            this.deleteCliente(clienteDTO.id());
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
