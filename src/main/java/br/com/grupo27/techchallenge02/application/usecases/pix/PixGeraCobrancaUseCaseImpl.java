package br.com.grupo27.techchallenge02.application.usecases.pix;

import br.com.efi.efisdk.EfiPay;
import br.com.efi.efisdk.exceptions.EfiPayException;
import br.com.grupo27.techchallenge02.application.usecases.pix.utils.PixUtils;
import br.com.grupo27.techchallenge02.domain.interfaces.usecase.pix.PixGeraCobrancaUseCase;
import br.com.grupo27.techchallenge02.domain.model.Cliente;
import br.com.grupo27.techchallenge02.domain.model.Pedido;
import br.com.grupo27.techchallenge02.external.config.Credenciais;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

public class PixGeraCobrancaUseCaseImpl implements PixGeraCobrancaUseCase{
    private final Credenciais credentials;
    private static final Logger logger = LoggerFactory.getLogger(PixGeraCobrancaUseCaseImpl.class);

    public PixGeraCobrancaUseCaseImpl(Credenciais credentials) {
        this.credentials = credentials;
    }

    @Override
    public HashMap<String, String> registraCobranca(Pedido pedido, Cliente cliente){
        JSONObject response = gerarCobranca(pedido, cliente);
        String id = extrairIdsDoResponse(response, "idCobranca");
        String idtx = extrairIdsDoResponse(response, "idtx");
        HashMap<String, String> ids =  new HashMap<>();
        ids.put(id, idtx);
        return ids;
    }

    private JSONObject gerarCobranca(Pedido pedido, Cliente cliente) {
        JSONObject options = configurarOpcoes();
        JSONObject body = construirCorpoCobranca(pedido, cliente);

        try {
            EfiPay efi = new EfiPay(options);
            JSONObject response = efi.call("pixCreateImmediateCharge", new HashMap<>(), body);
            logger.info("EfiPay: {}", response);

            return response;
        } catch (EfiPayException e) {
            logger.error("Erro ao criar cobrança PIX: {}", e.getErrorDescription());
            return null;
        } catch (Exception e) {
            logger.error("Erro desconhecido: {}", e.getMessage());
            return null;
        }
    }

    private String extrairIdsDoResponse(JSONObject response, String key) {
        if (response != null && response.has(key)) {
            return response.getString(key);
        } else {
            logger.error("O JSON de resposta não contém a chave '{}' ou é nulo.", key);
            return null;
        }
    }
    
    private JSONObject configurarOpcoes() {
        return PixUtils.configurarOpcoes(credentials);
    }

    private JSONObject construirCorpoCobranca(Pedido pedido, Cliente cliente) {
        return PixUtils.construirCorpoCobranca(pedido.getId(), cliente.getCpf().toString(), cliente.getNome());
    }
}
