package managedbeans;

import entities.Tarefa;
import persistence.TarefaDAOHibernate;

import javax.inject.Named;
import java.io.Serializable;

@Named
public class CadastrotarefaBean implements Serializable {

    private Tarefa tarefa = new Tarefa();
    private TarefaDAOHibernate dao = new TarefaDAOHibernate();



    public void cadastro()
    {

        System.out.println(tarefa.getDescricao());
        System.out.println(tarefa.getTitulo());
        dao.inserirtarefa(tarefa);
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }


}
