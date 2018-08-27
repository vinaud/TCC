package persistence;

import entities.Tarefa;

import java.util.List;

public interface ITarefaDAO {

    public void inserirtarefa(Tarefa tarefa);

    public  List<Tarefa> getTarefas();

    public Tarefa getTarefa();


}
