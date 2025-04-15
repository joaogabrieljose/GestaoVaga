package com.example.gestaovaga.controller.candidateController;

import com.example.gestaovaga.entity.candidate.CandidateEntity;
import com.example.gestaovaga.useCase.candidate.ProfileCandidateUseCase;
import com.example.gestaovaga.useCase.candidate.UseCaseCreate;

import com.example.gestaovaga.useCase.candidate.dto.ProfileCandidateResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/candidate")
public class ControllerCandidate {

    @Autowired
    private UseCaseCreate create;

    @Autowired
    private ProfileCandidateUseCase candidateUseCase;


    @PostMapping("/")
    public ResponseEntity<Object>create(@Valid @RequestBody CandidateEntity
                                                    candidateEntity){

        try {
            var novo = create.execute(candidateEntity);
            return ResponseEntity.ok().body(novo);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
                    body(ex.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('CANDIDATE')")
    public ResponseEntity<Object> get(HttpServletRequest request){

        var idCandidate = request.getAttribute("candidate_id");
        try {
            var profile =  this.candidateUseCase.execute
                    (UUID.fromString(idCandidate.toString()));
            return ResponseEntity.ok().body(profile);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
