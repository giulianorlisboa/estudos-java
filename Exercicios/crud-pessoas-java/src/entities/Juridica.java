package entities;

public class Juridica extends Pessoa {

    private String cnpj;
    private String nomeFantasia;

    public Juridica() {
    }

    public Juridica(String nome, String endereco, Integer telefone, String email, String cnpj, String nomeFantasia) {
        super(nome, endereco, telefone, email);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String toString() {
        IO.println("Nome: " + getNome());
        IO.println("Endereco: " + getEndereco());
        IO.println("Telefone: " + getTelefone());
        IO.println("Email: " + getEmail());
        IO.println("CNPJ: " + getCnpj());
        IO.println("Nome fantasia: " + getNomeFantasia());
        return super.toString();
    }
}
