package entities;

public class Tarefa {

    public Tarefa(){

    }

    public Tarefa(String titulo, String descricao)
    {
        this.titulo=titulo;
        this.descricao=descricao;
    }

    private String titulo = "tarefinha";

    private String descricao= "Lorem Ipsum!";

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
}
