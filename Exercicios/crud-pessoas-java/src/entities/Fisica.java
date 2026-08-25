package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fisica extends Pessoa {
    private String cpf;
    private LocalDate dataNascimento;

    final private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Fisica() {
        super();
    }

    public Fisica(String nome, String endereco, Long telefone, String email, String cpf, LocalDate dataNascimento) {
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
        return "Nome: " + getNome()
                + "\nEndereco: " + getEndereco()
                + "\nTelefone: " + getTelefone()
                + "\nEmail: " + getEmail()
                + "\nCPF: " + getCpf()
                + "\nData de Nascimento: " + getDataNascimento().format(formatter);
    }
}
