package br.edu.unisep.repository;

import br.edu.unisep.dto.AlunoDto;
import br.edu.unisep.entity.Aluno;
import com.rcpadilha.hibernate.dao.HibernateDao;

import java.util.List;
import java.util.stream.Collectors;

public class AlunoRepository {

    public List<AlunoDto> listar() {

        var dao = new HibernateDao<Aluno>();
        var rec = dao.find(Aluno.class);

        return rec.stream().map(
                r -> new AlunoDto(r.getId(), r.getNome())
        ).collect(Collectors.toList());

    }
}
