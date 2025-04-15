package com.example.gestaovaga.useCase.company;

import com.example.gestaovaga.entity.company.Company;
import com.example.gestaovaga.exception.UserFoundException;
import com.example.gestaovaga.repository.companyRepository.CompanyRepository;
import com.example.gestaovaga.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompanyUseCase {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public Company execute(Company company){
        this.repository.findByUsernameOrEmail(company.getUsername(),
                company.getEmail()).ifPresent((user)->{
                    throw new UserFoundException();
        });
        var password = encoder.encode(company.getPassword());
        company.setPassword(password);
        return this.repository.save(company);
    }

}
