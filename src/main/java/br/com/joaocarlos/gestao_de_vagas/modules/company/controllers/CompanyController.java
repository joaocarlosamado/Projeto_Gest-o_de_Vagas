package br.com.joaocarlos.gestao_de_vagas.modules.company.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaocarlos.gestao_de_vagas.modules.candidate.useCases.CreateCandidateUseCase;
import br.com.joaocarlos.gestao_de_vagas.modules.company.entities.CompanyEntity;
import br.com.joaocarlos.gestao_de_vagas.modules.company.useCases.CreateCompanyUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
        try{
            var result = this.createCompanyUseCase.execute(companyEntity);
            return ResponseEntity.ok().body(result);
        }catch(Exception e){
            // e.printStackTrace(); codigo q mostra o erro
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}