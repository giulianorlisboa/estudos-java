package model;

public class Cliente {
    private String nome;
    private int id;
    private int idade;

    public Cliente(String nome, int id, int idade) {
        this.nome = nome;
        this.id = id;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
