package br.com.joaocarlos.gestao_de_vagas.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class JWTCandidateProvider {

  @Value("${security.token.secret.candidate}")
  private String secretKey;

  public DecodedJWT validateToken(String token) {
    if (!token.startsWith("Bearer ")) {
      throw new IllegalArgumentException("Token inválido");
    }
    if (token.startsWith("Bearer ")) {
      token = token.replace("Bearer ", "");
    }
    // System.out.println(secretKey);
    // System.out.println(token);

    Algorithm algorithm = Algorithm.HMAC256(secretKey);

    try {
      var tokenDecoded = JWT.require(algorithm)
          .build()
          .verify(token);
      return tokenDecoded;
    } catch (JWTVerificationException e) {
      e.printStackTrace();
      return null;
    }
  }
}
