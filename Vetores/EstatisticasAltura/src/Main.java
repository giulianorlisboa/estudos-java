import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serao digitados? ");
        int n = sc.nextInt();
        double[] alturaPessoas = new double[n];
        char[] sexo = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Altura da " + (i + 1) + "a pessoa: ");
            alturaPessoas[i] = sc.nextDouble();
            System.out.print("Genero da " + (i + 1) + "a pessoa: ");
            sexo[i] = sc.next().toLowerCase().charAt(0);
        }

        double menorAltura = alturaPessoas[0];
        double maiorAltura = alturaPessoas[0];
        double somaAlturaMulheres = 0;
        int qtdMulheres = 0;
        int qtdHomens = 0;

        for (int i = 0; i < n; i++) {
            if (alturaPessoas[i] < menorAltura) menorAltura = alturaPessoas[i];
            if (alturaPessoas[i] > maiorAltura) maiorAltura = alturaPessoas[i];

            if (sexo[i] == 'f') {
                somaAlturaMulheres += alturaPessoas[i];
                qtdMulheres++;
            } else if (sexo[i] == 'm') {
                qtdHomens++;
            }
        }

        double mediaMulheres = qtdMulheres > 0 ? somaAlturaMulheres / qtdMulheres : 0;

        System.out.printf("Menor altura: %.2f%n", menorAltura);
        System.out.printf("Maior altura: %.2f%n", maiorAltura);
        System.out.printf("Media das alturas das mulheres: %.2f%n", mediaMulheres);
        System.out.printf("Quantidade de homens: %d%n", qtdHomens);

        sc.close();
    }
}