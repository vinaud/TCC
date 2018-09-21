package persistence;

import entities.Badge;
import entities.Tarefa;


public class AddTarefa {


    public static void main(String[] args) {

       UserDAOHibernate dao = new UserDAOHibernate();

        Badge b = new Badge();
        b.setTitulo("Testador iniciante");
        b.setObjetivo("Finalizar 10 tarefas");
        b.setIcon("b2");
        b.setUser(dao.getUsuario(56));

        BadgeDAOHibernate.inserirBadge(b);

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
