package managedbeans;

import entities.Erro;
import entities.Tarefa;
import persistence.ErroDAOHibernate;
import persistence.TarefaDAOHibernate;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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

    private String etitulo = "";
    private String edescricao= "";
    private String tipo = "";

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
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Tarefa cadastrada",  "Sucesso ao inserir a tarefa "+ tarefa.getTitulo() ) );
        tarefas = TarefaDAOHibernate.getTarefas();
    }

    public void insereErro()
    {
        Erro erro = new Erro();
        erro.setTarefa(tarefaP);
        erro.setDescricao(edescricao);
        erro.setTipo(tipo);
        erro.setTitulo(etitulo);

        ErroDAOHibernate.inserirErro(erro);
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

    public String getEtitulo() {
        return etitulo;
    }

    public void setEtitulo(String etitulo) {
        this.etitulo = etitulo;
    }

    public String getEdescricao() {
        return edescricao;
    }

    public void setEdescricao(String edescricao) {
        this.edescricao = edescricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
