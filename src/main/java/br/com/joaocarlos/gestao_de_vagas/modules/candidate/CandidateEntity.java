package br.com.joaocarlos.gestao_de_vagas.modules.candidate;

import java.util.UUID;

import lombok.Data;

@Data //criar todos os set e get
public class CandidateEntity {

    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String description;
    private String curriculum;
    
}
