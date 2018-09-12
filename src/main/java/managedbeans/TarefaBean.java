package managedbeans;

import entities.Tarefa;
import persistence.TarefaDAOHibernate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


//@Named
@ManagedBean
@SessionScoped
public class TarefaBean implements Serializable {

    public List<Tarefa> tarefas;
    private int tarefaid;
    public Tarefa tarefaP;


    @PostConstruct
    public void init() {

        tarefas = TarefaDAOHibernate.getTarefas();
        tarefaid = 0;

    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public String getHorario() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return "Atualizado em " + sdf.format(new Date());
    }


    public String getExibido(Tarefa p)
    {
        this.tarefaP = p;
        return "tarefa.xhtml?faces-redirect=true";
    }

    public Tarefa getTarefaP() {
        return tarefaP;
    }

    public void setTarefaP(Tarefa tarefaP) {
        this.tarefaP = tarefaP;
    }
}
