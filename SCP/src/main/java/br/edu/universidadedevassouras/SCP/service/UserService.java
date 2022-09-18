package br.edu.universidadedevassouras.SCP.service;


import br.edu.universidadedevassouras.SCP.Model.Pessoa;
import br.edu.universidadedevassouras.SCP.Repository.PessoaDAO;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PessoaDAO pessoaDAO;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Pessoa user = pessoaDAO.findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + userName);
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }


    public Pessoa save(Pessoa pessoa) {
        pessoa.setPassword(bcryptEncoder.encode(pessoa.getPassword()));
        return pessoaDAO.save(pessoa);
    }
}
