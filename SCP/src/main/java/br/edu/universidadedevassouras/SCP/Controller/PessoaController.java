package br.edu.universidadedevassouras.SCP.Controller;

import br.edu.universidadedevassouras.SCP.Model.Pessoa;
import br.edu.universidadedevassouras.SCP.Repository.PessoaDAO;
import br.edu.universidadedevassouras.SCP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaDAO pessoaDAO;
    private Pessoa pessoa;

    @Autowired
    private UserService userService;

    @GetMapping
    public @ResponseBody Iterable<Pessoa> getAll(){
       return pessoaDAO.findAll();
    }

    @GetMapping(path = "/pessoa/{id}")
    public @ResponseBody Optional<Pessoa> getPessoa(@PathVariable("id")Long id){
       return pessoaDAO.findById(id);
    }

    @PostMapping
    public Pessoa postPessoa(@RequestBody Pessoa p){
        return userService.save(p);
    }

    @DeleteMapping
    public void Delete(){
        pessoaDAO.deleteAll();
    }

    @PutMapping
    public Pessoa putPessoa(@RequestBody Pessoa p){

        return userService.save(p);
    }

}
