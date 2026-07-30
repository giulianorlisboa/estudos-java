import java.util.ArrayList;
import java.util.List;

public class CadastroDePessoa {
    private List<Pessoa> pessoas = new ArrayList<>();

    public void adicionarPessoa(Pessoa p) {
        pessoas.add(p);
    }

    public Pessoa obterMaisVelho() {
        Pessoa pessoaMaisVelho = pessoas.getFirst();
        for (Pessoa p : pessoas) {
            if (pessoaMaisVelho.getIdade() < p.getIdade()) {
                pessoaMaisVelho = p;
            }
        }
        return pessoaMaisVelho;
    }

    public double calcularMediaIdades() {
        if (pessoas.isEmpty()) {
            return 0;
        }
        int idadeTotal = 0;
        for (Pessoa p : pessoas) {
            idadeTotal += p.getIdade();
        }
        return (double) idadeTotal / pessoas.size();

    }

    public List<Pessoa> menoresDeIdade() {
        List<Pessoa> menoresDeIdade = new ArrayList<>();
        for (Pessoa p : pessoas) {
            if (p.getIdade() < 18){
                menoresDeIdade.add(p);
            }
        }
        return menoresDeIdade;
    }

}
