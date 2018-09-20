package managedbeans;

import entities.User;
import persistence.UserDAOHibernate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;


@ManagedBean
@SessionScoped
public class UserLoggedBean implements Serializable {
    UserDAOHibernate dao = new UserDAOHibernate();
    User logado;

    @PostConstruct
    public void login()
    {
        logado = dao.getUsuario(56);
    }


    public User getLogado() {
        return logado;
    }

    public void setLogado(User logado) {
        this.logado = logado;
    }
}
