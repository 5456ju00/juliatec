package com.ejcar.juliatec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejcar.juliatec.modelo.Professor;


@RestController //Transforma a nossa classe em um controller antigamente chamado de bin
@RequestMapping(value = "/professor") //Mapeando a URL, navegador chama pelo valor
public class ProfessorController {
    
    @GetMapping( value = "/imprimir") //Mapeamento do método imprimir. Usando o verbo Get => Pegar ou Buscar.
    public void imprimir(){
        System.out.println("chamou o metodo imprimir");
    }


    @GetMapping( value = "/ola") // Void não retorna nada!
    public String ola() { // Adicionando o retorno como String - Tipo texto // não quer dizer HTML
        return "<h1>Júlia</h1>"; // return => Devolve o retorno pra quem chamou
    }


    @GetMapping( value = "/insert")
    public String insert() {

        Professor professor = new Professor("Julia", "123456789");
        
        System.out.println(professor.toString());

        return "<h1>Tentando Salvar o Professor Dos Aluno</h1>";

    }
    
}
