package com.ejcar.juliatec.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ejcar.juliatec.dto.ProfessorDto;
import com.ejcar.juliatec.modelo.Professor;
import com.ejcar.juliatec.repositiry.ProfessorRepository;


@RestController //Transforma a nossa classe em um controller antigamente chamado de bin
@RequestMapping(value = "/professor") //Mapeando a URL, navegador chama pelo valor
public class ProfessorController {
    
    @Autowired
    private ProfessorRepository professorRepository;
    
    
    @GetMapping( value = "/imprimir") //Mapeamento do método imprimir. Usando o verbo Get => Pegar ou Buscar.
    public void imprimir(){
        System.out.println("chamou o metodo imprimir");
    }


    @GetMapping( value = "/ola") // Void não retorna nada!
    public String ola() { // Adicionando o retorno como String - Tipo texto // não quer dizer HTML
        return "<h1>Júlia</h1>"; // return => Devolve o retorno pra quem chamou
    }


    @PostMapping( value = "/insert")
    public ResponseEntity<?> insert(@RequestBody ProfessorDto professorDto) {

        Professor professor = professorDto.novoProfessor();
        
        System.out.println(professor.toString());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                                            .path("/id")
                                            .buildAndExpand(professor.getId())
                                            .toUri();

        professorRepository.save(professor);

        return ResponseEntity.created(uri).body(professor);

    }
    
}
