import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private int idade;
    private double altura;
    private LocalDate dataNascimento;

    public Pessoa(String nome, int idade, double altura, LocalDate dataNascimento) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    @Override
    public String toString() {
        return "Nome: " + nome
                + "\nIdade: " + idade
                + "\nAltura: " + String.format("%.2f", altura) + " m"
                + "\nData de Nascimento: " + dataNascimento
                + "\n";
    }

}
