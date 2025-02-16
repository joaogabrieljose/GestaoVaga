package com.example.gestaovaga.controller;

import com.example.gestaovaga.entity.candidate.CandidateEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class ControllerCandidate {

    @PostMapping("/")
    public ResponseEntity<Object>create(@Valid @RequestBody CandidateEntity candidateEntity){
        var novo = candidateEntity.getEmail();
        return ResponseEntity.ok().body(novo);
    }
}
