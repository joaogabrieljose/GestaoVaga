package com.example.gestaovaga.controller.companyController;

import com.example.gestaovaga.entity.company.Company;
import com.example.gestaovaga.useCase.company.CompanyUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyUseCase useCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Company company){

        try {
            var novo =  this.useCase.execute(company);
            return ResponseEntity.ok().body(novo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
