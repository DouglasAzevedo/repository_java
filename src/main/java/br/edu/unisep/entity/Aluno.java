package br.edu.unisep.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_aluno")
    private Integer id;

    @Column(name="ds_aluno")
    private String nome;

    @Column(name="ds_email")
    private String email;

    @Column(name="nr_periodo")
    private Integer periodo;
}
