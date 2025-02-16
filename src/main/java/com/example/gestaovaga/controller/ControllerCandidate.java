package com.example.gestaovaga.controller;

import com.example.gestaovaga.entity.candidate.CandidateEntity;
import com.example.gestaovaga.exception.UserFoundException;
import com.example.gestaovaga.repository.CandidateRepository;
import com.example.gestaovaga.useCase.candidate.UseCaseCreate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class ControllerCandidate {

    @Autowired
    private UseCaseCreate create;

    @PostMapping("/")
    public ResponseEntity<Object>  create(@Valid @RequestBody CandidateEntity
                                              candidateEntity){
        try {
            var result =  create.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
