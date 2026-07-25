package model;

public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private boolean emprestado;
    private String descricao;
    private String nomeCliente;

    public Livro(int id, String titulo, String autor, boolean emprestado, String descricao, String nomeCliente) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = emprestado;
        this.descricao = descricao;
        this.nomeCliente = nomeCliente;
    }

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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Override
    public String toString() {
        return "ID do livro: " + id
                + "Título: " + titulo
                + "\nAutor: " + autor
                + "\nDescricao: " + descricao
                + "\nStatus: " + (emprestado ? "Emprestado para " + nomeCliente : "Disponível");
    }
}
