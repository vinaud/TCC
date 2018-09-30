package entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "level")
    private int level;

    @Column(name = "exp")
    private long exp;

    @Column(name = "pontos")
    private long pontos;

    @Column(name = "icon")
    private String icon;

    @Column(name = "counter")
    private int counter;
    //contador de tarefas do usuario já validadas

    @Column(name = "patente")
    private String patente;

    @OneToMany(

            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Badge> badges = new ArrayList<>();

    @OneToMany(

            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Tarefa> tarefas = new ArrayList<>();




    public void addBadge(Badge badge) {
        badges.add(badge);
        badge.setUser(this);
    }

    public void addTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        tarefa.setUser(this);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public long getPontos() {
        return pontos;
    }

    public void setPontos(long pontos) {
        this.pontos = pontos;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }
}
