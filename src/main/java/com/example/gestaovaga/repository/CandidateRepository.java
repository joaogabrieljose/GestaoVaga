package com.example.gestaovaga.repository;

import com.example.gestaovaga.entity.candidate.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity,
        UUID> {


}
