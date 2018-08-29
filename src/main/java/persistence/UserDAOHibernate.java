package persistence;

import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDAOHibernate {

    public  void inserirusuario(User user)
    {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();

        System.out.println("ID do usuario: " + user.getId());

        manager.close();
    }

    public List<User> getUsuarios()
    {
        List<User> lista ;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();


        lista = manager.createQuery("FROM " + User.class.getName()).getResultList();
        return lista;
    }

    public User getUsuario()
    {
        return null;
    }
}
