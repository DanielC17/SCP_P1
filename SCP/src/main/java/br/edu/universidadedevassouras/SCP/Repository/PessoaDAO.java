package br.edu.universidadedevassouras.SCP.Repository;

import br.edu.universidadedevassouras.SCP.Model.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaDAO extends CrudRepository<Pessoa, Long> {

    Pessoa findByUsername(String userName);
}