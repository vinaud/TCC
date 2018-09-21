package persistence;

import entities.Badge;
import entities.Tarefa;


public class AddTarefa {


    public static void main(String[] args) {

       UserDAOHibernate dao = new UserDAOHibernate();

        Badge b = new Badge();
        b.setTitulo("Primeira Tarefa");
        b.setObjetivo("Finalizar a primeira tarefa no sistema");
        b.setIcon("b1");
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
