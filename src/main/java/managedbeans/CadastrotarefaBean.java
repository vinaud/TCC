package managedbeans;

import entities.Tarefa;
import persistence.TarefaDAOHibernate;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;

@Named
public class CadastrotarefaBean implements Serializable {

    private Tarefa tarefa = new Tarefa();
    private TarefaDAOHibernate dao = new TarefaDAOHibernate();


    @PostConstruct
    public void init() {

        tarefa.setTitulo(" ");
        tarefa.setDescricao(" ");
    }

    public void cadastro()
    {

        dao.inserirtarefa(tarefa);
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }


}
