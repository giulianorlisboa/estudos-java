package model;

public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private boolean emprestado;
    private String descricao;

    public Livro(int id, String titulo, String autor, boolean emprestado, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = emprestado;
        this.descricao = descricao;
    }

    Cliente cliente;

    public int getId() {
        return id;
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

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo
                + ", Autor: " + autor
                + ", Status: " + (emprestado ? "Emprestado para " + cliente.getNome() : "Disponível")
                + ", Descricao: " + descricao;
    }
}
