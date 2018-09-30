package persistence;

import entities.Badge;
import entities.Tarefa;
import entities.User;
import gaming.BadgeMaker;


public class AddTarefa {


    public static void main(String[] args) {
UserDAOHibernate dao = new UserDAOHibernate();
      User u = dao.getUsuario(56);
        BadgeMaker.earnVaderBadge(u);

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
