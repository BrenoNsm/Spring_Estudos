package br.edu.uerr.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uerr.demo.model.Pessoa;
import br.edu.uerr.demo.repository.PessoaRepository;
// import io.micrometer.core.ipc.http.HttpSender.Response;


@RestController
@RequestMapping("/api/exemplo")


public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping(value = "/{nome}")
    public String exemplo(@PathVariable("nome")String nome){
        return "Ola "+ nome;
    }
    //pega pessoa pessoa pelo id
    @GetMapping(value = "/pessoa/{id}")
    public ResponseEntity<Pessoa> pegaPessoaPeloId(@PathVariable Integer id){
        return pessoaRepository.findById(id)
            .map(record->ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
    }
    //para salvar 
    @PostMapping(value = "/pessoa")
    public Pessoa salvar(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
    //metodo para alterar
    public String alterar(){
        return null;
    }
    //metodo para lista todos
    public String listaTodos(){
        return null;
    }
    //metodo para deletar
    public String deletar(){
        return null;
    }
}
