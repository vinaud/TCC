package managedbeans;

import entities.Tarefa;
import persistence.TarefaDAOHibernate;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Named
public class TarefaBean implements Serializable {

    public List<Tarefa> tarefas;


    @PostConstruct
    public void init() {

     //   tarefas = TarefaDAOHibernate.getTarefas();
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public String getHorario() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return "Atualizado em " + sdf.format(new Date());
    }






}
