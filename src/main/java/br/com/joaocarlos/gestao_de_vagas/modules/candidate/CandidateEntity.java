package br.com.joaocarlos.gestao_de_vagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data // criar todos os set e get
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    // não permitir usa espaço
    @NotBlank
    @Pattern(regexp = "(/\\b(\\s)\\b/g)", message = "O campo [username] não deve conter espaço") // expressao regular
    private String username;

    @Email(message = "O Campo [email] deve conter um e-mail válido")
    private String email;

    @Length(min = 6, max = 8, message = "A senha deve conter entre (6) e (8) caracteres")
    private String password;
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
