package managedbeans;

import entities.User;
import persistence.UserDAOHibernate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;


@ManagedBean
@ViewScoped
public class UserLoggedBean implements Serializable {
    UserDAOHibernate dao = new UserDAOHibernate();
    User logado;
    int nextxp=0;
    int reason=0;

    @PostConstruct
    public void login()
    {
        logado = dao.getUsuario(56);
        nextxp = logado.getLevel()*110;
        reason = Math.round((logado.getExp()*100)/nextxp );
       // reason = 60;
    }


    public User getLogado() {
        return logado;
    }

    public void setLogado(User logado) {
        this.logado = logado;
    }

    public int getNextxp() {
        return nextxp;
    }

    public void setNextxp(int nextxp) {
        this.nextxp = nextxp;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }
}
