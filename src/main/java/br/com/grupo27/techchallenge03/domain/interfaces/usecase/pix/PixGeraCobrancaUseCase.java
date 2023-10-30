package br.com.grupo27.techchallenge03.domain.interfaces.usecase.pix;

import java.util.HashMap;

import br.com.grupo27.techchallenge03.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge03.domain.model.Cliente;
import br.com.grupo27.techchallenge03.domain.model.Pedido;

public interface PixGeraCobrancaUseCase {
    public HashMap<String, String>registraCobranca(PedidoDTO pedido, Cliente cliente);

}
