package br.edu.uerr.demo.repository;

import br.edu.uerr.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}
