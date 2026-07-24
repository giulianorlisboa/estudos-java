public class Funcionario {
    private int id;
    private String nome;
    private double salario;

    public Funcionario(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void aumentarSalario(double porcentagem) {
        double calculoAumento = salario * (porcentagem / 100);
        salario += calculoAumento;
    }

    @Override
    public String toString() {
        return String.format("ID: %-3d Nome: %-10s Salário: R$ %.2f", id, nome, salario);
    }



}
