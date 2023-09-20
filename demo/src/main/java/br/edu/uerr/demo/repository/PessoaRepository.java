package br.edu.uerr.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.uerr.demo.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
