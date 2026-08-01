import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Conta {
    private int numero;
    private String titular;
    private double saldo;
    private LocalDateTime dataCriacao;
    private List<Transacao> historico = new ArrayList<>();

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Conta(int numero, String titular, LocalDateTime dataCriacao) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        this.dataCriacao = dataCriacao;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            Transacao transacao = new Transacao("Deposito", valor, LocalDateTime.now());
            this.historico.add(transacao);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0) {
            if (saldo - valor >= 0) {
                this.saldo -= valor;
                Transacao transacao = new Transacao("Saque", valor, LocalDateTime.now());
                this.historico.add(transacao);
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("O valor para saque deve ser maior que 0,00.");
        }
    }

    public List<Transacao> getHistorico() {
        return historico;
    }

    @Override
    public String toString() {
        return "Número da conta: " + numero +
                "\nTitular: " + titular +
                "\nSaldo: R$ " + String.format("%.2f", saldo) +
                "\nData de criação: " + dataCriacao.format(fmt);
    }
}



