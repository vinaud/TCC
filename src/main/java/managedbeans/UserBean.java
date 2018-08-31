package managedbeans;

import entities.User;
import persistence.UserDAOHibernate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ManagedBean
public class UserBean implements Serializable {

    private User user = new User();
    private UserDAOHibernate dao = new UserDAOHibernate();
    private String username = "";
    private String nome = "";

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void cadastrar()
    {
        user.setUsername(username);
        user.setName(nome);
        dao.inserirusuario(user);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
