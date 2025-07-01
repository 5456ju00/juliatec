package com.ejcar.juliatec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorController {
    
    @GetMapping( value = "/imprimir")
    public void imprimir(){
        System.out.println("chamou o metodo imprimir");
    }


    @GetMapping( value = "/ola")
    public String ola() {
        return "<h1>Júlia</h1>";
    }


    @GetMapping( value = "/insert")
    public String insert() {

        return "<h1>Tentando Salvar o Professor Dos Aluno</h1>";

    }
    
}
