package persistence;

import entities.Badge;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class BadgeDAOHibernate {

    public static void inserirBadge(Badge badge) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(badge);
        manager.getTransaction().commit();

        System.out.println("ID da badge inserida: " + badge.getId());

        manager.close();
    }

    public static List<Badge> getBadges() {
        List<Badge> lista ;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();


        lista = manager.createQuery("FROM " + Badge.class.getName()).getResultList();
        return lista;
    }

    public static List<Badge> getBadgesById(long id) {

        List<Badge> lista ;
        lista = getBadges();
        List<Badge> retorno = new ArrayList<Badge>();



        for (int i = 0; i<lista.size(); i++)
        {
            if(lista.get(i).getUser().getId()== id)
            {
                retorno.add(lista.get(i));
            }
        }
        return retorno;
    }

}
