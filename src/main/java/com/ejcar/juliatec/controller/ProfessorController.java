package com.ejcar.juliatec.controller;

import java.net.URI;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    
    @GetMapping( value = "/listaprofessor")    
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @DeleteMapping( value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        System.out.println( "O valor do id -->" + id);
        professorRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping( value = "/{id}")
    public ResponseEntity<Professor> select(@PathVariable Long id) {

        System.out.println( "O valor do id -->" + id);
        return ResponseEntity.ok().body(professorRepository.findById(id).orElse(null));

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








//******************************************************************************************************************************* */
                                        //Criar o esqueleto do método.  
                                        //Como receber a informação do que eu preciso?
                                        //    public String nomeDoMetodo(entrada) {
                                                    //sem saída
                                        //        return // => Saída do método

                                        //    }

                                        //Preparar o método para receber a entrada
                                        //  public void delete ( Long id ) {
                                        //}


                                        //O que eu preciso fazer?
                                        //Preciso apagar (deletar) um registro.
                                        //Preciso de alguma informação para completar a tarefa?
                                        
                                        //Já tenho o id (imformação)
                                        //Preciso ultilizar o Repository (Banco de Dados)
                                        //Escolher um dos métodos do CRUD

                                        //C => CREATE => INSERT
                                        //R => READ => SELECT
                                        //U => UPDATE => UPDATE
                                        //D => DELETE => DELETE

                                        //Preciso Mappear o método, afim de chamar da camada externa 
                                        //Como injetar o valor do id na entrada do método de forma dinâmica, pois não posso mappear para todos os ids
                                        //EXAMPLO:
                                        // /delete/1
                                        // /delete/2
                                        // /delete/3 
                                        //e DeleteMapping( value = "/delete")
                                        
                                        //Criar Resposta (Response) mais Adequada
                                            //como foi efetuado o delete de um recurso
                                            //Se eu quiser posso devolver uma resposta ou não 
                                        // => Resposta Padrão
                                            // public ResponseEntity<Void> delete(@PathVariable Long id){

                                            //}
                           

