package com.ejcar.juliatec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorController {
    

    @GetMapping( value = "/")
    public void imprimir(){
        System.out.println("chamou o metodo imprimir");
    }


    
}
