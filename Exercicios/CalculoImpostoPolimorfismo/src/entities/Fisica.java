package entities;

public class Fisica extends Pessoa{

    private Double gastoSaude;

    public Fisica() {
        super();
    }

    public Fisica(String nome, Double rendaAnual, Double gastoSaude) {
        super(nome, rendaAnual);
        this.gastoSaude = gastoSaude;
    }

    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }

    @Override
    public Double calcularImposto() {

        Double imposto = 0.0;
        if (getRendaAnual() < 20000){
            if (gastoSaude > 0){
                imposto = (getRendaAnual() * 0.15) - (gastoSaude * 0.5);
            } else {
                imposto = (getRendaAnual() * 0.15);
            }
        } else {
            if (gastoSaude > 0){
                imposto = (getRendaAnual() * 0.25) - (gastoSaude * 0.5);
            } else {
                imposto = (getRendaAnual() * 0.25);
            }
        }
        return imposto;
    }
}
