package br.edu.uerr.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exemplo")

public class PessoaController {
    
    @GetMapping(value = "/{nome}")
    public String exemplo(@PathVariable("nome")String nome){
        return "Ola "+ nome;
    }

    public String salvar(){
        return null;
    }

    public String alterar(){
        return null;
    }

    public String listaTodos(){
        return null;
    }

    public String deletar(){
        return null;
    }
}
