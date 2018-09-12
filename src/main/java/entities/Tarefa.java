package entities;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tarefas")
public class Tarefa {


    public Tarefa(){

    }

    public Tarefa(String titulo, String descricao)
    {
        this.titulo=titulo;
        this.descricao=descricao;
    }



    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name="descricao")
    private String descricao;

    @Column(name="dificuldade")
    private int dificuldade;

    @OneToMany(

            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Erro> erros = new ArrayList<>();

    public void addErro(Erro erro) {
        erros.add(erro);
        erro.setTarefa(this);
    }

    public void removeComment(Erro erro) {
        erros.remove(erro);
        erro.setTarefa(null);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }
    public void setId(long id){this.id=id;}

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
}
