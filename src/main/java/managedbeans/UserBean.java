package managedbeans;

import entities.User;
import persistence.UserDAOHibernate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@ViewScoped
public class UserBean implements Serializable {


    private UserDAOHibernate dao = new UserDAOHibernate();
    private String username = "";
    private String nome = "";
    private List<User> users;


    @PostConstruct
    public void init() {

        users = dao.getUsuarios();
    }

    public void cadastrar()
    {
        User user = new User();
        user.setUsername(username);
        user.setName(nome);
        user.setLevel(1);
        dao.inserirusuario(user);
    }

    public List<User> usuarios()
    {
         users = dao.getUsuarios();
        return users;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
