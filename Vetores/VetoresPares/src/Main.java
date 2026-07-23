import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros você vai digitar? ");
        int n = sc.nextInt();

        int[] numeros = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Digite um numero: ");
            numeros[i] = sc.nextInt();
        }

        int qtdPares = 0;
        System.out.println("NUMEROS PARES: ");
        for (int i = 0; i < n; i++) {
            if (numeros[i] % 2 == 0) {
                qtdPares++;
                System.out.print(numeros[i] + " ");
            }
        }
        System.out.println();
        System.out.println("QUANTIDADE DE PARES= " + qtdPares);
    }

}