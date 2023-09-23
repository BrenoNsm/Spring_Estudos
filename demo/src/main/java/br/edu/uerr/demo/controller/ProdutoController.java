package br.edu.uerr.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto")

public class ProdutoController {
    @GetMapping(value= "/{prodnome}")
    public String produto(@PathVariable("prodnome")String prodnome){
        return "O seu produto é: " + prodnome;
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
