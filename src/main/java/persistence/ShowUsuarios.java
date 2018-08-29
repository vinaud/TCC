package persistence;

import entities.User;

import java.util.List;

public class ShowUsuarios {

    public static void main(String[] args) {

         UserDAOHibernate dao = new UserDAOHibernate();


        List<User> lista = dao.getUsuarios();

        for (User u : lista)
        {
            System.out.println(u.getName()+" " + u.getUsername() + "  " + u.getExp() + "  " + u.getLevel());
        }
    }
}
