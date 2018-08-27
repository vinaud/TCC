package persistence;

import entities.Tarefa;


public class AddTarefa {


    public static void main(String[] args) {

        TarefaDAOHibernate t = new TarefaDAOHibernate();
        Tarefa tarefa = new Tarefa("Tarefa teste 3 nova","Add main dao");

        t.inserirtarefa(tarefa);

/*
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(tarefa);
        manager.getTransaction().commit();

        System.out.println("ID da tarefa: " + tarefa.getId());

        manager.close();*/
    }
}
