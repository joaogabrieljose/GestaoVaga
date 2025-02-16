package com.example.gestaovaga.entity.candidate;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateEntity {

    private UUID id;
    private String name;
    @Pattern(regexp = "^(?!\\s*$).+",message = "o campo [username]não de espaço")
    private String username;
    @Email(message ="o campo (email) deve conter um e-mail valido")
    private String email;
    private String description;
    private String password;
    private String curriculum;
}
