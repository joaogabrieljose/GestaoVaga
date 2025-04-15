package com.example.gestaovaga.useCase.jobs;

import com.example.gestaovaga.entity.company.Company;
import com.example.gestaovaga.entity.job.Job;
import com.example.gestaovaga.exception.UserFoundException;
import com.example.gestaovaga.repository.jobRepository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobUseCase {

    @Autowired
    private JobRepository repository;

    public Job execute(Job job){

        this.repository.findByIdOrDescription(job.getId(), job.getDescription())
                .ifPresent((use) ->{
                 throw new UserFoundException();
        });
        return repository.save(job);
    }
}
