package br.com.grupo27.techchallenge02.adapters.pix;

import br.com.efi.efisdk.EfiPay;
import br.com.efi.efisdk.exceptions.EfiPayException;
import br.com.grupo27.techchallenge02.Credenciais;

import org.json.JSONObject;

import java.util.HashMap;

public class PixCobrancaImediata {

    public static void main(String[] args) {

        Credenciais credentials = new Credenciais();

        JSONObject options = new JSONObject();
        options.put("client_id", credentials.getClientId());
        options.put("client_secret", credentials.getClientSecret());
        options.put("certificate", credentials.getCertificate());
        options.put("sandbox", credentials.isSandbox());


        JSONObject body = new JSONObject();
        body.put("calendario", new JSONObject().put("expiracao", 3600));
        body.put("devedor", new JSONObject().put("cpf", "12345678909").put("nome", "Teste"));
        body.put("valor", new JSONObject().put("original", "0.01"));
        body.put("chave", "4b4bd5d4-1060-4fe6-b643-562803049d66");
        body.put("solicitacaoPagador", "Serviço realizado.");

        try {
            EfiPay efi = new EfiPay(options);
            JSONObject response = efi.call("pixCreateImmediateCharge", new HashMap<String,String>(), body);
            System.out.println(response);
        }catch (EfiPayException e){
            System.out.println(e.getError());
            System.out.println(e.getErrorDescription());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
