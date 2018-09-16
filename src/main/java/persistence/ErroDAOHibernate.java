package persistence;

import entities.Erro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ErroDAOHibernate {

    public static void inserirErro(Erro erro) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(erro);
        manager.getTransaction().commit();

        System.out.println("ID do erro inserido: " + erro.getId());

        manager.close();
    }

    public static List<Erro> getTarefas() {
        List<Erro> lista ;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();


        lista = manager.createQuery("FROM " + Erro.class.getName()).getResultList();
        return lista;
    }





}
