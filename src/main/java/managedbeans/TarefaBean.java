package managedbeans;

import entities.Erro;
import entities.Tarefa;
import entities.User;
import filesmanager.GeradorRelatorio;
import gaming.Game;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import persistence.ErroDAOHibernate;
import persistence.TarefaDAOHibernate;
import persistence.UserDAOHibernate;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


//@Named
@ManagedBean
@SessionScoped
public class TarefaBean implements Serializable {

    public List<Tarefa> tarefas;

    public List<Erro> errosP;//erros da tarefa visualizada
    public Tarefa tarefaP;//tarefa sendo visualizada

    private List<Tarefa> tarefasV; // tarefas validadas
    private List<Tarefa> tarefasF; // tarefas finalizadas (nao validadas)

    private TarefaDAOHibernate dao = new TarefaDAOHibernate();
    private UserDAOHibernate userdao = new UserDAOHibernate();
    private String titulo = "";
    private String descricao = "";

    private String etitulo = "";
    private String edescricao= "";
    private String tipo = "";

    private int dif = 1;
    private int horas = 1;


    private StreamedContent file;

   /* public TarefaBean ()
    {
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("C:\\Users\\João Vinaud\\Desktop\\relatorioTeste.txt");
        file = new DefaultStreamedContent(stream, "application/txt", "relatorioTeste.txt");
    }*/

    @PostConstruct
    public void init() {

        tarefas = TarefaDAOHibernate.getTarefas();
        tarefasV= TarefaDAOHibernate.getTarefasValidadas();
        tarefasF=TarefaDAOHibernate.getTarefasFinalizadas();


    }

    public void cadastro()
    {
        Tarefa tarefa  = new Tarefa();
        tarefa.setTitulo(titulo);
        tarefa.setDescricao(descricao);
        tarefa.setDificuldade(dif);
        tarefa.setHorasEsperadas(horas);
        tarefa.setStatus("Aberta");
        dao.inserirtarefa(tarefa);
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Tarefa cadastrada",  "Sucesso ao inserir a tarefa "+ tarefa.getTitulo() ) );
        tarefas = TarefaDAOHibernate.getTarefas();
    }

    public String insereErro()
    {
        Erro erro = new Erro();
        erro.setTarefa(tarefaP);
        erro.setDescricao(edescricao);
        erro.setTipo(tipo);
        erro.setTitulo(etitulo);

        ErroDAOHibernate.inserirErro(erro);
        errosP = ErroDAOHibernate.getErrosById(tarefaP.getId());

        Game.updateTarefaXP(tarefaP,erro);

        return "tarefa.xhtml?faces-redirect=true";
    }

    public String assumirTarefa(User user)
    {

        tarefaP.setUser(user);
        TarefaDAOHibernate.update(tarefaP);
        init();
        return "tarefa.xhtml?faces-redirect=true";
    }

    public String finalizarTarefa()
    {
        tarefaP.setStatus("Finalizada");
        TarefaDAOHibernate.update(tarefaP);
        init();
        return "tarefa.xhtml?faces-redirect=true";
    }

    public String validarTarefa()
    {
        tarefaP.setStatus("Validada");
        TarefaDAOHibernate.update(tarefaP);

        User tarefaUser = tarefaP.getUser();
        tarefaUser.setCounter(tarefaUser.getCounter()+1);
        UserDAOHibernate.update(tarefaUser);

        Game.earnBadge(tarefaP, tarefaUser);
        Game.gainPoints(tarefaP,tarefaUser);
        Game.gainXP(tarefaP,tarefaUser);

        init();
        return "tarefa.xhtml?faces-redirect=true";
    }

    public void gerarRelatorioTarefa()
    {
        String param = "";
        param = param + "Tarefa "+tarefaP.getTitulo() + "\r\n";
        param = param + "ID: "+tarefaP.getId() + "\r\n";
        param = param + "Descrição:"+tarefaP.getDescricao() + "\r\n";
        param = param + "Testador:"+tarefaP.getUser().getName()+ "\r\n";
        param = param +  "Erros encontrados: \r\n \r\n";

        for(Erro e : errosP)
        {
            param = param + e.getTitulo() +" \r\n";
            param = param +"Tipo: "+ e.getTipo()+ "\r\n";
            param = param + "Descrição do erro: \r\n"+e.getDescricao() +"\r\n \r\n";
            param = param +"---------------------------------------------------- \r\n \r\n";
        }

        try
        {
            GeradorRelatorio.writeStream(param);
          //  InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("C:\\Users\\João Vinaud\\Desktop\\relatorioTeste.txt");
          //  file = new DefaultStreamedContent(stream, "application/txt", "relatorioTeste.txt");

            ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
            File result = new File(extContext.getRealPath("C:\\Users\\João Vinaud\\Desktop\\relatorioTeste.txt"));
            InputStream stream = new FileInputStream("C:\\Users\\João Vinaud\\Desktop\\relatorioTeste.txt");
            file = new DefaultStreamedContent(stream, "application/txt", "relatorioTeste.txt");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Relatório gerado com sucesso"));

        } catch (IOException e) {
            e.printStackTrace();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Falha ao gerar o relatório"));
        }

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
        errosP = ErroDAOHibernate.getErrosById(p.getId());
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

    public List<Erro> getErrosP() {
        return errosP;
    }

    public void setErrosP(List<Erro> errosP) {
        this.errosP = errosP;
    }

    public List<Tarefa> getTarefasV() {
        return tarefasV;
    }

    public void setTarefasV(List<Tarefa> tarefasV) {
        this.tarefasV = tarefasV;
    }

    public List<Tarefa> getTarefasF() {
        return tarefasF;
    }

    public void setTarefasF(List<Tarefa> tarefasF) {
        this.tarefasF = tarefasF;
    }

    public StreamedContent getFile() {
        return file;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
}
