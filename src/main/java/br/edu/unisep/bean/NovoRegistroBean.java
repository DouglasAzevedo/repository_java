package br.edu.unisep.bean;

import br.edu.unisep.dto.AlunoDto;
import br.edu.unisep.dto.CategoriaDto;
import br.edu.unisep.dto.NovoRegistroDto;
import br.edu.unisep.dto.RegistroHorasDto;
import br.edu.unisep.entity.Aluno;
import br.edu.unisep.entity.Categoria;
import br.edu.unisep.entity.RegistroHoras;
import br.edu.unisep.repository.AlunoRepository;
import br.edu.unisep.repository.CategoriaRepository;
import br.edu.unisep.repository.RegistroRepository;
import com.rcpadilha.hibernate.dao.HibernateDao;
import com.rcpadilha.hibernate.exception.DaoException;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class NovoRegistroBean {

    @Getter
    @Setter
    private NovoRegistroDto registro;

    @Getter
    @Setter
    private List<AlunoDto> alunos;

    @Getter
    @Setter
    private List<CategoriaDto> categorias;

    private RegistroRepository repRegistro = new RegistroRepository();
    private AlunoRepository aRepo = new AlunoRepository();
    private CategoriaRepository cRepo = new CategoriaRepository();

    @PostConstruct
    public void iniciar() {
         this.alunos = aRepo.listar();
         this.categorias = cRepo.listar();

         this.registro = new NovoRegistroDto();
    }

    public String salvar() {
        try {
            repRegistro.salvar(registro);
            return "index?faces-redirect=true";
        } catch (DaoException e) {
            return "novoRegistro?faces-redirect=true";
        }

    }

}
