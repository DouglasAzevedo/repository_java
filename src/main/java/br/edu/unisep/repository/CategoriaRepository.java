package br.edu.unisep.repository;

import br.edu.unisep.dto.CategoriaDto;
import br.edu.unisep.entity.Categoria;
import com.rcpadilha.hibernate.dao.HibernateDao;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaRepository {

    public List<CategoriaDto> listar() {

        var dao = new HibernateDao<Categoria>();
        var rec = dao.find(Categoria.class);

        return rec.stream().map(
                r -> new CategoriaDto(r.getId(), r.getDescricao())
        ).collect(Collectors.toList());
    }
}
