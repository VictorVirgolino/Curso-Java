package sef.module3.sample.aula5_31_07_2024;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;

    //Construtor
    public Livro(int id, String titulo, String autor, int anoPublicacao){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String toString(){
        return String.format("Livro{id=%d, titulo='%s', autor='%s', anoPublicacao=%d}", id, titulo, autor, anoPublicacao);
    }
}
