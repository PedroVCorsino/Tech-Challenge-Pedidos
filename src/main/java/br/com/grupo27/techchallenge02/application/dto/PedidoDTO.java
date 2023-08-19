package br.com.grupo27.techchallenge02.application.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.grupo27.techchallenge02.core.enums.StatusPedido;

public record PedidoDTO(
    Long id,
    Long idCliente,
    List<ComboDTO> combos,
    BigDecimal valorTotal,
    StatusPedido status,
    boolean pago
) {

}
