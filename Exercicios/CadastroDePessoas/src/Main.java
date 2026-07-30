import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CadastroDePessoa cadastro = new CadastroDePessoa();

        System.out.print("Digite a quantidade de pessoas que deseja cadastrar: ");
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            System.out.print("Digite o seu nome completo: ");
            String nome = sc.nextLine();
            System.out.print("Insira sua idade: ");
            int idade = sc.nextInt();
            sc.nextLine();
            System.out.print("Insira sua altura (Ex. 1,80): ");
            double altura = sc.nextDouble();
            sc.nextLine();
            System.out.print("Insira sua data de nascimento (Ex. 01/01/2000): ");
            String dataNascimento = sc.nextLine();
            System.out.println();

            Pessoa p = new Pessoa(nome, idade, altura, dataNascimento);
            cadastro.adicionarPessoa(p);
        }

        System.out.println("cadastro mais velha:\n" + cadastro.obterMaisVelho());
        System.out.println("A média de idade das pessoas é de: " + String.format("%.2f", cadastro.calcularMediaIdades()) + " anos\n");
        System.out.println("Menores de idade: ");
        for (Pessoa p : cadastro.menoresDeIdade()){
            System.out.println(p);
        }
    }
}