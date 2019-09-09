package br.edu.unisep.bean;

import br.edu.unisep.dto.RegistroHorasDto;
import br.edu.unisep.entity.RegistroHoras;
import br.edu.unisep.repository.RegistroRepository;
import com.rcpadilha.hibernate.dao.HibernateDao;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class RegistrosBean {

    @Getter @Setter
    private List<RegistroHorasDto> registros;

    @PostConstruct
    public void iniciar() {
        var registro = new RegistroRepository();
        this.registros = registro.listar();
    }

}
