package br.com.grupo27.techchallenge02.domain.interfaces.usecase.pix;

import java.util.HashMap;
import java.util.Map;

import br.com.grupo27.techchallenge02.domain.model.Cliente;
import br.com.grupo27.techchallenge02.domain.model.Pedido;

public interface PixUseCase {
    HashMap<String, String> gerarCobranca(Pedido pedido, Cliente cliente);
    String gerarQrCode(String string);
    Boolean consultaStatusPagamento(String idtx);
}
