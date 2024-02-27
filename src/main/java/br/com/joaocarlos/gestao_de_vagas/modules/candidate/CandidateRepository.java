package br.com.joaocarlos.gestao_de_vagas.modules.candidate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity,UUID>{
    Optional <CandidateEntity> findByUsernameOrEmail(String username,String email);//findBy e para fazer uma busca no banco 
    
}
