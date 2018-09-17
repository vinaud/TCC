package persistence;

import entities.Erro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
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

    public static List<Erro> getErros() {
        List<Erro> lista ;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();


        lista = manager.createQuery("FROM " + Erro.class.getName()).getResultList();
        return lista;
    }

    public static List<Erro> getErrosById(long id) {
        List<Erro> lista ;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
        EntityManager manager = factory.createEntityManager();


        lista = manager.createQuery("FROM " + Erro.class.getName()).getResultList();
        List<Erro> retorno = new ArrayList<Erro>();

        for (int i = 0; i<lista.size(); i++)
        {
            if(lista.get(i).getTarefa().getId()== id)
            {
                retorno.add(lista.get(i));
            }
        }
        return retorno;
    }





}
