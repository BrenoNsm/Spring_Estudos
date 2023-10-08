package br.edu.uerr.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uerr.demo.model.Pessoa;
import br.edu.uerr.demo.model.Produto;
import br.edu.uerr.demo.repository.PessoaRepository;
import br.edu.uerr.demo.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/exemplo")

public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;
    
    @GetMapping(value= "/{prodnome}")
    public String produto(@PathVariable("prodnome")String prodnome){
        return "O seu produto é: " + prodnome;
    }

    @GetMapping(value = "/produto/{id}")
    public ResponseEntity<Produto> pegaProdutoPeloId(@PathVariable Integer id){
        return produtoRepository.findById(id)
            .map(record->ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
    }
     //mandar produto ou salvar
    @PostMapping(value = "/produto")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Produto salvar(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @PutMapping(value = "/produto/{id}")
    public ResponseEntity<Produto> alterarProduto(@PathVariable("id")Integer id, @RequestBody Produto produto){
        return produtoRepository.findById(id)
            .map(record->{
                record.setNome(produto.getNome());
                record.setDescricao(produto.getDescricao());
                record.setPreco(produto.getPreco());
                record.setQuantidade(produto.getQuantidade());
                record.setDataCompra(produto.getDataCompra());
                Produto alteracao = produtoRepository.save(record);
                return ResponseEntity.ok().body(alteracao);
            }).orElse(ResponseEntity.notFound().build());
    }

    public String listaTodos(){
        return null;
    }
    @DeleteMapping(value = "/produto/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable("id") Integer id){
        return produtoRepository.findById(id)
            .map(record->{
                produtoRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
