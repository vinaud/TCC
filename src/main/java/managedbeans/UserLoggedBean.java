package managedbeans;

import entities.Badge;
import entities.User;
import persistence.BadgeDAOHibernate;
import persistence.UserDAOHibernate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@ViewScoped
public class UserLoggedBean implements Serializable {
    UserDAOHibernate dao = new UserDAOHibernate();
    User logado;
    int nextxp=0;
    int reason=0;
    private Badge selectdBadge;

    private List<Badge> badgesP;

    @PostConstruct
    public void login()
    {
        logado = dao.getUsuario(56);
        nextxp = logado.getLevel()*110;
        reason = Math.round((logado.getExp()*100)/nextxp );

        badgesP = BadgeDAOHibernate.getBadgesById(logado.getId());
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

    public List<Badge> getBadgesP() {
        return badgesP;
    }

    public void setBadgesP(List<Badge> badgesP) {
        this.badgesP = badgesP;
    }

    public Badge getSelectdBadge() {
        return selectdBadge;
    }

    public void setSelectdBadge(Badge selectdBadge) {
        this.selectdBadge = selectdBadge;
    }
}
