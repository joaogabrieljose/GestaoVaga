package com.example.gestaovaga.controller.jobController;

import com.example.gestaovaga.entity.job.Job;
import com.example.gestaovaga.security.dto.JobDtoCreate;
import com.example.gestaovaga.useCase.jobs.JobUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private JobUseCase useCase;

    @PostMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    public Job create(@Valid @RequestBody JobDtoCreate jobDtoCreate,
                                         HttpServletRequest request){

        var companyId = request.getAttribute("company_id");

        //job.setCompanyId(UUID.fromString(companyId.toString()));

        var jobeEntity = Job.builder()
                .benefits(jobDtoCreate.getBenefits())
                .companyId(UUID.fromString(companyId.toString()))
                .description(jobDtoCreate.getDescription())
                .level(jobDtoCreate.getLevel())
                .build();

        return this.useCase.execute(jobeEntity);
    }
}
