package persistence;

import entities.Tarefa;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;


public  class TarefaDAOHibernate  {


    public  void inserirtarefa(Tarefa tarefa) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(tarefa);
        manager.getTransaction().commit();

        System.out.println("ID da tarefa inserida: " + tarefa.getId());

        manager.close();
    }
    //@Override
    public static List<Tarefa> getTarefas() {
         List<Tarefa> lista ;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();


        lista = manager.createQuery("FROM " + Tarefa.class.getName()).getResultList();
        return lista;
    }

   // @Override
    public Tarefa getTarefa() {
        return null;
    }
}
