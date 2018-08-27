package persistence;

import entities.Tarefa;

import java.util.List;

public class ShowTarefas {

    public static void main(String[] args) {

       // TarefaDAOHibernate t = new TarefaDAOHibernate();


       List<Tarefa> lista = TarefaDAOHibernate.getTarefas();

       for (Tarefa tarefa : lista)
       {
           System.out.println(tarefa.getTitulo()+" " + tarefa.getDescricao() + "  " + tarefa.getId());
       }
    }
}
