package br.com.grupo27.techchallenge02.application.usecases;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import br.com.grupo27.techchallenge02.adapters.gateways.PagamentoGateway;
import br.com.grupo27.techchallenge02.adapters.gateways.PedidoGateway;
import br.com.grupo27.techchallenge02.adapters.mappers.PagamentoMapper;
import br.com.grupo27.techchallenge02.adapters.mappers.PedidoMapper;
import br.com.grupo27.techchallenge02.application.dto.PagamentoDTO;
import br.com.grupo27.techchallenge02.application.dto.PedidoDTO;
import br.com.grupo27.techchallenge02.domain.interfaces.usecase.PagamentoUsecase;
import br.com.grupo27.techchallenge02.domain.interfaces.usecase.PedidoUseCase;
import br.com.grupo27.techchallenge02.domain.interfaces.usecase.pix.PixUseCase;
import br.com.grupo27.techchallenge02.domain.model.Cliente;
import br.com.grupo27.techchallenge02.domain.model.Pedido;

public class PagamentoUseCaseImpl implements PagamentoUsecase {

    private final PedidoGateway pedidoGateway;
    private final PedidoMapper pedidoMapper;
    private final PixUseCase pix;
    private final PagamentoGateway pagamentoGateway;
    private final PagamentoMapper pagamentoMapper;

    public PagamentoUseCaseImpl(PedidoGateway pedidoGateway, PedidoMapper pedidoMapper, PixUseCase pix, PagamentoGateway pagamentoGateway, PagamentoMapper pagamentoMapper) {
        this.pedidoGateway = pedidoGateway;
        this.pedidoMapper = pedidoMapper;
        this.pix = pix;
        this.pagamentoGateway = pagamentoGateway;
        this.pagamentoMapper = pagamentoMapper;
    }

    @Override
    public Boolean consultaStatusPagamento(Long id) {
        PagamentoDTO pagamentoDTO = pagamentoMapper.domainToDto(pagamentoGateway.findPagamentoByIdPedido(id));
        return pix.consultaStatusPagamento(pagamentoDTO.idtx());
    }

    @Override
    public Boolean verificaStatusPagamento(Long id) {
        PedidoDTO pedidoDto = pedidoMapper.domainToDto(pedidoGateway.findPedidoById(id));
    
        if (pedidoDto == null) {
            throw new RuntimeException("Pedido não encontrado");
        }
    
        if (pedidoDto.pago()) {
            return true; 
        }
    
        boolean isPago = consultaStatusPagamento(pedidoDto.id());
    
        if (isPago) {
            Pedido pedido = pedidoMapper.dtoToDomain(pedidoDto);
            pedido.setPago(true);
            pedidoGateway.updatePedido(id, pedido);
            return true; 
        } else {
            return false;
        }
    }
    

    @Override
    public List<PedidoDTO> findPedidosByStatusPagamento(boolean pago) {
        List<Pedido> pedidos = pedidoGateway.findPedidosByStatusPagamento(pago);
        return pedidos.stream().map(pedidoMapper::domainToDto).collect(Collectors.toList());
    }

    @Override
    public String geraQrCodePedido(Long id) {
        PagamentoDTO pagamentoDTO = pagamentoMapper.domainToDto(pagamentoGateway.findPagamentoByIdPedido(id));

        if (pagamentoDTO == null) {
            throw new RuntimeException("Pedido não encontrado");
        }

        return pix.gerarQrCode(pagamentoDTO.idCobranca());

    }

    @Override
    public void gerarCobranca(PedidoDTO pedido, Cliente cliente) {
        HashMap<String, String> cobrancaData = pix.gerarCobranca(pedido, cliente);
        String idCobranca = cobrancaData.get("idCobranca");
        String idTx = cobrancaData.get("txid");
    
        if (idCobranca == null || idTx == null) {
            throw new RuntimeException("Falha ao gerar a cobrança. Dados de cobrança ausentes.");
        }

        PagamentoDTO pagamentoDTO = new PagamentoDTO(
            null,
            idCobranca,
            idTx,
            pedido.id()
        );

        pagamentoGateway.savePagamento(pagamentoMapper.dtoToDomain(pagamentoDTO));
    }
    

}
