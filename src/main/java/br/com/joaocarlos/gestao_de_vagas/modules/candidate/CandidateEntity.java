package br.com.joaocarlos.gestao_de_vagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data //criar todos os set e get
public class CandidateEntity {

    private UUID id;
    private String name;
    
    //não permitir usa espaço 
    @NotBlank
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço") //expressao regular
    private String username;

    @Email(message = "O Campo [email] deve conter um e-mail válido")
    private String email;

    @Length(min = 6, max = 8, message = "A senha deve conter entre (6) e (8) caracteres")
    private String password;
    private String description;
    private String curriculum;
    
}
