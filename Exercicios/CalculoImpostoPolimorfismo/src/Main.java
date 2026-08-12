import entities.Fisica;
import entities.Juridica;
import entities.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pessoa> pessoasList = new ArrayList<>();
        Double totalImpostos = 0.0;

        System.out.print("Digite o numero de contribuintes: ");
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= N; i++) {
            System.out.print("Pessoa fisica ou pessoa juridica (F/J)? ");
            String opcao = sc.nextLine();
            if (opcao.equalsIgnoreCase("F")) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Renda anual: ");
                Double renda = sc.nextDouble();
                sc.nextLine();
                System.out.print("Gastos com saúde: ");
                Double gastos = sc.nextDouble();
                sc.nextLine();
                pessoasList.add(new Fisica(nome, renda, gastos));
            } else if (opcao.equalsIgnoreCase("J")) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();
                System.out.print("Renda anual: ");
                Double renda = sc.nextDouble();
                sc.nextLine();
                System.out.print("Quantidade de funcionarios: ");
                int qtdFuncionarios = sc.nextInt();
                sc.nextLine();
                pessoasList.add(new Juridica(nome, renda, qtdFuncionarios));
            }  else {
                System.out.println("Opção inserida é invalida.");
                i--;
            }
        }

        System.out.println("TAXES PAID:");
        for (Pessoa p : pessoasList) {
            Double imposto = p.calcularImposto();
            System.out.println(p.exibirDados(imposto));
            totalImpostos += imposto;
        }

        System.out.println("Total de impostos: " + String.format("%.2f", totalImpostos));

        sc.close();
    }
}