import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantas pessoas voce vai digitar: ");
        int n = sc.nextInt();
        String[] nomes = new String[n];
        int[] idades = new int[n];

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Dados da " + (i + 1) + "a pessoa: ");
            System.out.print("Nome: ");
            nomes[i] = sc.nextLine();
            System.out.print("Idade: ");
            idades[i] = sc.nextInt();
            sc.nextLine();
        }

        String pessoaMaisVelha = nomes[0];
        int idadeMaisVelha = idades[0];
        for (int i = 0; i < n; i++) {
            if (idades[i] > idadeMaisVelha) {
                idadeMaisVelha = idades[i];
                pessoaMaisVelha = nomes[i];
            }
        }

        System.out.println("PESSOA MAIS VELHA: " + pessoaMaisVelha);

        sc.close();
    }
}