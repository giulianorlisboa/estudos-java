package entities;

import java.time.LocalDate;

public class Fisica extends Pessoa {
    private String cpf;
    private LocalDate dataNascimento;

    public Fisica() {
        super();
    }

    public Fisica(String nome, String endereco, Integer telefone, String email, String cpf, LocalDate dataNascimento) {
        super(nome, endereco, telefone, email);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        IO.println("Nome: " + getNome());
        IO.println("Endereco: " + getEndereco());
        IO.println("Telefone: " + getTelefone());
        IO.println("Email: " + getEmail());
        IO.println("CPF: " + getCpf());
        IO.println("Data de Nascimento: " + getDataNascimento());
        return super.toString();
    }
}
