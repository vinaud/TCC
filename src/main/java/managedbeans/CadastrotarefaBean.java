package managedbeans;

import entities.Tarefa;
import persistence.TarefaDAOHibernate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class CadastrotarefaBean implements Serializable {

    private Tarefa tarefa = new Tarefa();
    private TarefaDAOHibernate dao = new TarefaDAOHibernate();
    private String titulo = "";
    private String descricao = "";




    public void cadastro()
    {
        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        dao.inserirtarefa(tarefa);
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
