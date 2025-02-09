package com.example.gestaovaga.entity.candidate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateEntity {

    private UUID id;
    private String name;
    private String username;
    private String email;
    private String description;
    private String password;
    private String curriculum;



}
