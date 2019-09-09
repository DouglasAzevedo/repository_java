package br.edu.unisep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistroHorasDto {

    private String descricao;

    private Integer horas;

    private String aluno;

    private String categoria;
}
