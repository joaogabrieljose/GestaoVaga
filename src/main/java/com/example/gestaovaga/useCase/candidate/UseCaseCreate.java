package com.example.gestaovaga.useCase.candidate;

import com.example.gestaovaga.entity.candidate.CandidateEntity;
import com.example.gestaovaga.exception.UserFoundException;
import com.example.gestaovaga.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseCaseCreate {

    @Autowired
    private CandidateRepository repository;

    public CandidateEntity execute(CandidateEntity candidateEntity){
        repository.findByUsernameOrEmail(candidateEntity.getUsername(),
                candidateEntity.getEmail()).ifPresent((use) -> {

            throw new UserFoundException();
        });
        return repository.save(candidateEntity);
    }
}
