package managedbeans;

import entities.Tarefa;

import javax.inject.Named;
import java.io.Serializable;


@Named
public class TarefaBean implements Serializable {

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    private Tarefa tarefa = new Tarefa("tarefosa","Bacons ipsum");



}
