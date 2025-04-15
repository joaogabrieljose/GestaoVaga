package com.example.gestaovaga.repository.cnadidateRepository;

import com.example.gestaovaga.entity.candidate.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

import java.util.UUID;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity,
        UUID> {

   Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);

   Optional<CandidateEntity> findByUsername (String username);


}
