import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos elementos vai ter o vetor? ");
        int n = sc.nextInt();
        int[] numeros = new int[n];
        int somaPares = 0;
        int qtdPares = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um numero: ");
            numeros[i] = sc.nextInt();
            if (numeros[i] % 2 == 0) {
                somaPares += numeros[i];
                qtdPares++;
            }
        }

        if (qtdPares == 0) {
            System.out.println("NENHUM NUMERO PAR");
        } else {
            double media = (double) somaPares / qtdPares;
            System.out.printf("MEDIA DOS PARES = %.1f%n", media);
        }

        sc.close();
    }
}