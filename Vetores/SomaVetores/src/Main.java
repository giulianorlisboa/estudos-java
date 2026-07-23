import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos valores vai ter cada vetor? ");
        int n = sc.nextInt();
        int[] vetA = new int[n];
        int[] vetB = new int[n];
        int[] vetC = new int[n];

        System.out.println("Digite os valores do vetor A: ");
        for (int i = 0; i < n; i++) {
            vetA[i] = sc.nextInt();
        }

        System.out.println("Digite os valores do vetor B: ");
        for (int i = 0; i < n; i++) {
            vetB[i] = sc.nextInt();
        }

        System.out.println("VALOR RESULTANTE: ");
        for (int i = 0; i < n; i++) {
            vetC[i] = vetA[i] + vetB[i];
            System.out.println(vetC[i]);
        }

        sc.close();
    }
}