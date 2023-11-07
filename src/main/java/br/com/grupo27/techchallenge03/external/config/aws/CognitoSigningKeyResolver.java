package br.com.grupo27.techchallenge03.external.config.aws;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SigningKeyResolverAdapter;

import java.security.Key;

public class CognitoSigningKeyResolver extends SigningKeyResolverAdapter {
    private final JwkProvider jwkProvider;

    public CognitoSigningKeyResolver(JwkProvider jwkProvider) {
        this.jwkProvider = jwkProvider;
    }

    @Override
    public Key resolveSigningKey(JwsHeader header, Claims claims) {
        try {
            Jwk jwk = jwkProvider.get((String) header.get("kid"));
            return jwk.getPublicKey();
        } catch (JwkException e) {
            throw new RuntimeException("Failed to get JWT public key from Cognito", e);
        }
    }
}
