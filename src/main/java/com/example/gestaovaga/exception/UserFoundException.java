package com.example.gestaovaga.exception;

public class UserFoundException extends RuntimeException {

    public UserFoundException(){
        super("usuario já existem");
    }
}
