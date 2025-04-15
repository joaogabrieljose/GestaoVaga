package com.example.gestaovaga.repository.jobRepository;

import com.example.gestaovaga.entity.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {
    Optional<Job> findByIdOrDescription(UUID id, String description);
}
