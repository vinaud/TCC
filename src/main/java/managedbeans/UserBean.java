package managedbeans;

import entities.User;
import persistence.UserDAOHibernate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;


@ManagedBean
@SessionScoped
public class UserBean implements Serializable {


    private UserDAOHibernate dao = new UserDAOHibernate();
    private String username = "";
    private String nome = "";


    public void cadastrar()
    {
        User user = new User();
        user.setUsername(username);
        user.setName(nome);
        user.setLevel(1);
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
