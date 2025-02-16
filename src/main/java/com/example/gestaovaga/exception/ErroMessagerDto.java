package com.example.gestaovaga.exception;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroMessagerDto {

    private String message;
    private String field;

}
