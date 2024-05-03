package br.com.joaocarlos.gestao_de_vagas.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class JWTProvider {

  @Value("${security.token.secret}")
  private String secretKey;

  public String validateToken(String token) {
    if (!token.startsWith("Bearer ")) {
      throw new IllegalArgumentException("Token inválido");
    }
    if (token.startsWith("Bearer ")) {
      token = token.replace("Bearer ", "");
    }

    Algorithm algorithm = Algorithm.HMAC256(secretKey);

    try {
      var subject = JWT.require(algorithm)
          .build()
          .verify(token)
          .getSubject();

      return subject;
    } catch (JWTVerificationException ex) {
      ex.printStackTrace();
      return "";
    }
  }
}
