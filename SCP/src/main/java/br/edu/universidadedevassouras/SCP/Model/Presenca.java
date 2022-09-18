package br.edu.universidadedevassouras.SCP.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Presenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPresenca;
    @Column(nullable = false)
    private Date Data;
    @Column(nullable = false)
    private Boolean Situacao;
    @ManyToOne
    private Pessoa pessoa;

}
