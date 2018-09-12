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

    public Tarefa tarefaP;//tarefa sendo visualizada

    private TarefaDAOHibernate dao = new TarefaDAOHibernate();
    private String titulo = "";
    private String descricao = "";
    private int dif = 1;


    @PostConstruct
    public void init() {

        tarefas = TarefaDAOHibernate.getTarefas();


    }

    public void cadastro()
    {
        Tarefa tarefa  = new Tarefa();
        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        tarefa.setDificuldade(dif);
        dao.inserirtarefa(tarefa);
        tarefas = TarefaDAOHibernate.getTarefas();
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDif() {
        return dif;
    }

    public void setDif(int dif) {
        this.dif = dif;
    }
}
