package entities;

import javax.persistence.*;

@Entity
@Table(name = "erros")
public class Erro {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="tipo")
    private String tipo;

    @Column(name="descricao")
    private String descricao;

    @Column(name="titulo")
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tarefa_id")
    private Tarefa tarefa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Erro )) return false;
        return id != null && id.equals(((Erro) o).id);
    }
    @Override
    public int hashCode() {
        return 31;
    }
}
