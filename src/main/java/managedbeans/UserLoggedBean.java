package managedbeans;

import entities.Badge;
import entities.Tarefa;
import entities.User;
import persistence.BadgeDAOHibernate;
import persistence.TarefaDAOHibernate;
import persistence.UserDAOHibernate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
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
    private List<Tarefa> tarefasP;
    private List<Tarefa> tarefasA;
    private List<Tarefa> tarefasF;

    private String loginUsername;
    private String loginPass;
    private int loginId;

    @PostConstruct
    public void login()
    {
        logado = dao.getUsuario(56);
        nextxp = logado.getLevel()*110;
        reason = Math.round((logado.getExp()*100)/nextxp );

        badgesP = BadgeDAOHibernate.getBadgesById(logado.getId());
        tarefasP= TarefaDAOHibernate.getTarefasById(logado.getId());
        tarefasA = tarefasAberta(tarefasP);
        tarefasF = tarefasFinalizada(tarefasP);
    }

    public String login2()
    {
        logado = dao.getUsuario(loginId);
        nextxp = logado.getLevel()*110;
        reason = Math.round((logado.getExp()*100)/nextxp );

        badgesP = BadgeDAOHibernate.getBadgesById(logado.getId());
        tarefasP= TarefaDAOHibernate.getTarefasById(logado.getId());
        tarefasA = tarefasAberta(tarefasP);
        tarefasF = tarefasFinalizada(tarefasP);

        return "home.xhtml?faces-redirect=true";
    }

    public List<Tarefa> tarefasAberta(List<Tarefa> tarefas)
    {
        List<Tarefa> retorno = new ArrayList<Tarefa>();

        for (int i = 0; i<tarefasP.size(); i++)
        {
            if(tarefasP.get(i).getUser() != null && tarefasP.get(i).getStatus().equals("Aberta"))
            {
                retorno.add(tarefasP.get(i));
            }
        }
        return retorno;
    }

    public List<Tarefa> tarefasFinalizada(List<Tarefa> tarefas)
    {
        List<Tarefa> retorno = new ArrayList<Tarefa>();

        for (int i = 0; i<tarefasP.size(); i++)
        {
            if(tarefasP.get(i).getUser() != null && (tarefasP.get(i).getStatus().equals("Finalizada") || tarefasP.get(i).getStatus().equals("Validada")))
            {
                retorno.add(tarefasP.get(i));
            }
        }
        return retorno;
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

    public List<Tarefa> getTarefasP() {
        return tarefasP;
    }

    public void setTarefasP(List<Tarefa> tarefasP) {
        this.tarefasP = tarefasP;
    }

    public List<Tarefa> getTarefasA() {
        return tarefasA;
    }

    public void setTarefasA(List<Tarefa> tarefasA) {
        this.tarefasA = tarefasA;
    }

    public List<Tarefa> getTarefasF() {
        return tarefasF;
    }

    public void setTarefasF(List<Tarefa> tarefasF) {
        this.tarefasF = tarefasF;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }
}
