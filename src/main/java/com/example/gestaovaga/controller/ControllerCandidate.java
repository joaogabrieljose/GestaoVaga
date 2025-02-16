package com.example.gestaovaga.controller;

import com.example.gestaovaga.entity.candidate.CandidateEntity;
import com.example.gestaovaga.repository.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class ControllerCandidate {

    @Autowired
    private CandidateRepository repository;


    @PostMapping("/")
    public ResponseEntity<Object>create(@Valid @RequestBody CandidateEntity
                                                    candidateEntity){
        var novo = repository.save(candidateEntity);
        return ResponseEntity.ok().body(novo);
    }
}
