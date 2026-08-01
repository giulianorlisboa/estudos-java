import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco gerenciador = new Banco();


        boolean sistemaAtivo = true;
        while (sistemaAtivo) {
            System.out.println("bem vindo ao banco.");
            System.out.println("O que deseja fazer? ");
            System.out.println("1 - abrir conta");
            System.out.println("2 - acessar conta");
            System.out.println("0 - sair");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    Conta novaConta = null;
                    System.out.println("Abertura de conta");
                    System.out.print("Insira o nome completo do titular da conta: ");
                    String titular = sc.nextLine();
                    System.out.print("Deseja realizar um deposito inicial? (S / N) ");
                    char depositoInicial = sc.next().toLowerCase().charAt(0);
                    if (depositoInicial == 's') {
                        System.out.print("Insira o valor do deposito inicial: ");
                        double valorDeposito = sc.nextDouble();
                        sc.nextLine();
                        novaConta = gerenciador.criarConta(titular, valorDeposito);
                        System.out.println("Conta criada com sucesso!");
                    } else if (depositoInicial == 'n') {
                        System.out.println("Abertura de conta sem deposito!");
                        novaConta = gerenciador.criarConta(titular, 0);
                        System.out.println("Conta criada com sucesso!");
                    } else {
                        System.out.println("Opção inválida! Conta não foi criada.");
                        break;
                    }
                    System.out.println(novaConta);
                    break;
                case 2:
                    System.out.println("Login");
                    System.out.print("Insira o numero da sua conta: ");
                    int numeroConta = sc.nextInt();
                    sc.nextLine();
                    Conta contaAcessada = gerenciador.buscarConta(numeroConta);
                    if (contaAcessada != null) {
                        boolean b = true;
                        while (b) {
                            System.out.println("Bem vindo, " + contaAcessada.getTitular());
                            System.out.println();
                            System.out.println("O que deseja fazer? ");
                            System.out.println("1 - sacar dinheiro");
                            System.out.println("2 - depositar dinheiro");
                            System.out.println("3 - exibir saldo");
                            System.out.println("4 - exibir extrato");
                            System.out.println("0 - finalizar");
                            int opcao2 = sc.nextInt();
                            sc.nextLine();
                            switch (opcao2) {
                                case 1:
                                    System.out.println("saque");
                                    System.out.println("Insira o valor que deseja sacar ");
                                    double valorSacar = sc.nextDouble();
                                    sc.nextLine();
                                    contaAcessada.sacar(valorSacar);
                                    System.out.println(contaAcessada);
                                    break;
                                case 2:
                                    System.out.println("Deposito");
                                    System.out.println("Insira o valor que deseja depositar");
                                    double valorDeposito = sc.nextDouble();
                                    sc.nextLine();
                                    contaAcessada.depositar(valorDeposito);
                                    System.out.println(contaAcessada);
                                    break;
                                case 3:
                                    System.out.println("Saldo em conta");
                                    System.out.println("O seu saldo disponivel é de: R$" + String.format("%.2f", contaAcessada.getSaldo()) + " reais");
                                    break;
                                case 4:
                                    System.out.println("Extrato");
                                    if (contaAcessada.getHistorico().isEmpty()) {
                                        System.out.println("Nenhuma transação registrada.");
                                    }
                                    for (Transacao t : contaAcessada.getHistorico()) {
                                        System.out.println(t);
                                    }
                                    break;
                                case 0:
                                    System.out.println("Voltando ao menu principal...");
                                    b = false;
                                    break;
                                default:
                                    System.out.println("opcao invalida, tente novamente!");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Conta nao encontrada!");
                    }
                    break;
                case 0:
                    System.out.println("Saindo do banco...");
                    sistemaAtivo = false;
                    break;

                default:
                    System.out.println("Opcao invalida, tente novamente!");
                    break;
            }
        }
    }
}