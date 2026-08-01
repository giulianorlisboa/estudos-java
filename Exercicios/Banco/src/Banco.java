import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banco {
    private List<Conta> contas = new ArrayList<>();
    private Random rand = new Random();

    private int gerarNumeroConta(){
        int numero;
        boolean existe;

        do {
            numero = rand.nextInt(9999);
            existe = false;
            for (Conta c : contas) {
                if (c.getNumero() == numero) {
                    existe = true;
                    break;
                }
            }
        }  while (existe);
        return numero;
    }

    public Conta criarConta(String titular, double saldoInicial) {
        int numero = gerarNumeroConta();
        Conta c = new Conta(numero, titular, LocalDateTime.now());
        if (saldoInicial > 0) {
            c.depositar(saldoInicial);
        }
        contas.add(c);
        return c;
    }

    public Conta buscarConta(int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }
}
