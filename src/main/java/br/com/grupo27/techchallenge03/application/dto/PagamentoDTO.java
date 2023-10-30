package br.com.grupo27.techchallenge03.application.dto;

public record PagamentoDTO(
    Long id,
    String idCobranca,
    String idtx,
    Long idPedido
) {

}
