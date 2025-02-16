package com.example.gestaovaga.entity.company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name="companys")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    // @Pattern(regexp = "\\s+",message = "o campo [username]não de espaço")
    private String username;
    @Email(message ="o campo (email) deve conter um e-mail valido")
    private String email;
    private String password;
    private String website;
    private String description;
    @CreationTimestamp
    private LocalDateTime creatdAt;

}
