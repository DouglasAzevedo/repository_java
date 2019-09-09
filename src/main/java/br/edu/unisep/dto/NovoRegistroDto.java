package br.edu.unisep.dto;

import lombok.Data;

@Data
public class NovoRegistroDto {

    private String descricao;

    private Integer horas;

    private Integer aluno;

    private Integer categoria;
}
