package com.example.gestaovaga.entity.candidate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="candidate")
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
   // @Pattern(regexp = "\\s+",message = "o campo [username]não de espaço")
    private String username;
    @Email(message ="o campo (email) deve conter um e-mail valido")
    private String email;
    private String description;
    private String password;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createAt;
}
