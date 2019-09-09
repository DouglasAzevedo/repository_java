package br.edu.unisep.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Integer id;

    @Column(name="ds_categoria")
    private String descricao;

}
