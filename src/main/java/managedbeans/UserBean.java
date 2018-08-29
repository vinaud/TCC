package managedbeans;

import entities.User;
import persistence.UserDAOHibernate;

import javax.inject.Named;
import java.io.Serializable;

@Named
public class UserBean implements Serializable {

    private User user = new User();
    private UserDAOHibernate dao = new UserDAOHibernate();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void cadastrar()
    {
        dao.inserirusuario(user);
    }
}
