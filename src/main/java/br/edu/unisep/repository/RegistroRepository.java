package br.edu.unisep.repository;

import br.edu.unisep.dto.NovoRegistroDto;
import br.edu.unisep.dto.RegistroHorasDto;
import br.edu.unisep.entity.Aluno;
import br.edu.unisep.entity.Categoria;
import br.edu.unisep.entity.RegistroHoras;
import com.rcpadilha.hibernate.dao.HibernateDao;
import com.rcpadilha.hibernate.exception.DaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegistroRepository {

    public List<RegistroHorasDto> listar() {

        var dao = new HibernateDao<RegistroHoras>();
        var rec = dao.find(RegistroHoras.class);
        return rec.stream().map(
                r -> new RegistroHorasDto(r.getDescricao(), r.getHoras(), r.getAluno().getNome(),
                        r.getCategoria().getDescricao())).collect(Collectors.toList());

    }

    public void salvar(NovoRegistroDto reg) throws DaoException {

        var registro = new RegistroHoras();

        var aluno = new Aluno();
        aluno.setId(reg.getAluno());

        var categoria = new Categoria();
        categoria.setId(reg.getCategoria());

        registro.setAluno(aluno);
        registro.setCategoria(categoria);
        registro.setDescricao(reg.getDescricao());
        registro.setHoras(reg.getHoras());

        var reDao = new HibernateDao<RegistroHoras>();
        reDao.save(registro);

    }

}
