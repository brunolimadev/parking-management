package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.model.entity.User;
import br.com.fiap.parkingmanagement.service.JwtService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${api.security.jwt.secret}")
    private String secret;

    /**
     * Método responsável por gerar um token JWT
     *
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public String generateToken(User user) throws Exception {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("Parking Management")
                    .withSubject(user.getEmail())
                    .withClaim("id", user.getId())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token!", e);
        }
    }

    /**
     * Método responsável por validar um token JWT
     *
     * @param token
     * @return
     */
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("Parking Management")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }

    /**
     * Método responsável por gerar a data de expiração do token
     *
     * @return
     */
    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
