package com.example.gestaovaga.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class ControllerCandidate {


    @PostMapping("/")
    public void create(){

    }
}
