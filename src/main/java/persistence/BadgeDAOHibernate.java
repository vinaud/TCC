package persistence;

import entities.Badge;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BadgeDAOHibernate {

    public static void inserirBadge(Badge badge) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(badge);
        manager.getTransaction().commit();

        System.out.println("ID do erro inserido: " + badge.getId());

        manager.close();
    }

    public static List<Badge> getBadges() {
        List<Badge> lista ;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();


        lista = manager.createQuery("FROM " + Badge.class.getName()).getResultList();
        return lista;
    }


}
