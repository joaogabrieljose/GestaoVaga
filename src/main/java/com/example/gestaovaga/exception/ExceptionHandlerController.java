package com.example.gestaovaga.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {


    private MessageSource source;

    public ExceptionHandlerController(MessageSource source) {
        this.source = source;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class )
    public ResponseEntity<List<ErroMessagerDto>> handleMethodArgumentException(MethodArgumentNotValidException e){

        List<ErroMessagerDto> dtoList= new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(err ->{
            String messager = source.getMessage(err,
                    LocaleContextHolder.getLocale());

            ErroMessagerDto error = new ErroMessagerDto(messager,err.getField());
            dtoList.add(error);
        });

        return new ResponseEntity<>(dtoList, HttpStatus.BAD_REQUEST);
    }

}
