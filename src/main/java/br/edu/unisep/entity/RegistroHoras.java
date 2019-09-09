package br.edu.unisep.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="registro_horas")
public class RegistroHoras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_registro")
    private Integer id;

    @Column(name="ds_registro")
    private String descricao;

    @Column(name="nr_horas")
    private Integer horas;

    @OneToOne
    @JoinColumn(name="id_aluno")
    private Aluno aluno;

    @OneToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
}
