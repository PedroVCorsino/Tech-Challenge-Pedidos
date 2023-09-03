package br.com.grupo27.techchallenge02.domain.interfaces.usecase.pix;

import java.util.HashMap;

import br.com.grupo27.techchallenge02.domain.model.Cliente;
import br.com.grupo27.techchallenge02.domain.model.Pedido;

public interface PixGeraCobrancaUseCase {
    public HashMap<String, String>registraCobranca(Pedido pedido, Cliente cliente);

}
