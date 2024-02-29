package br.com.joaocarlos.gestao_de_vagas.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaocarlos.gestao_de_vagas.modules.company.entities.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID>{
    Optional <CompanyEntity> findByUsernameOrEmail(String username,String email);//findBy e para fazer uma busca no banco 
    
}
