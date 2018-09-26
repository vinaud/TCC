package persistence;

import entities.Badge;
import entities.Tarefa;


public class AddTarefa {


    public static void main(String[] args) {

      Tarefa t = TarefaDAOHibernate.getTarefa(53);

        System.out.println("ID da tarefa: " + t.getId());
        System.out.println("dificuldade: " + t.getDificuldade());

        t.setDificuldade(4);

        TarefaDAOHibernate.update(t);

        t = TarefaDAOHibernate.getTarefa(53);

        System.out.println("dificuldade nova: " + t.getDificuldade());
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
