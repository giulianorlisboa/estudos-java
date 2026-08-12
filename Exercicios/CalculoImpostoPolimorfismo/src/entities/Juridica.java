package entities;

public class Juridica extends Pessoa {

    private Integer qtdFuncionarios;

    public Juridica() {
        super();
    }

    public Juridica(String nome, Double rendaAnual, Integer qtdFuncionarios) {
        super(nome, rendaAnual);
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public Integer getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(Integer qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    @Override
    public Double calcularImposto() {
        Double imposto = 0.0;
        if (qtdFuncionarios <= 10) {
            imposto = getRendaAnual() * 0.16;
        }else {
            imposto = getRendaAnual() * 0.14;
        }
        return imposto;
    }

}
