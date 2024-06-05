package com.usermanager.api.module.auth.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(String userCpf, Collection<? extends GrantedAuthority> authorities) {
        try {
            Instant now = Instant.now();
            long expiry = 3600L;

            String[] scopes = authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .toArray(String[]::new);

            Algorithm algorithm = Algorithm.HMAC256(this.secret);
            return JWT.create()
                    .withIssuer("user-manager-api")
                    .withSubject(userCpf)
                    .withExpiresAt(now.plusSeconds(expiry))
                    .withArrayClaim("scope", scopes)
                    .sign(algorithm);

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar Token ", exception);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("user-manager-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            return "";
        }
    }
}
