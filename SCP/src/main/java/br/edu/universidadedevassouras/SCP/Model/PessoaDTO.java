package br.edu.universidadedevassouras.SCP.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PessoaDTO {
    private String username;
    private String password;
    private String nome;
    private String cpf;
    private int matricula;
}


