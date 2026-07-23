import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // evita problema de virgula/ponto ao ler double

        System.out.print("Quantos elementos vai ter o vetor? ");
        int n = sc.nextInt();

        double[] vetor = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um numero: ");
            vetor[i] = sc.nextDouble();
        }

        double media = calcularMedia(vetor);

        System.out.printf("%nMEDIA DO VETOR = %.3f%n", media);
        System.out.println("ELEMENTOS ABAIXO DA MEDIA:");

        for (double numero : vetor) {
            if (numero < media) {
                System.out.printf("%.1f%n", numero);
            }
        }

        sc.close();
    }

    private static double calcularMedia(double[] vetor) {
        double soma = 0;
        for (double numero : vetor) {
            soma += numero;
        }
        return soma / vetor.length;
    }
}