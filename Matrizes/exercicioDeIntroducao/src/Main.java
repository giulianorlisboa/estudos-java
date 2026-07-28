import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//      Um programa que leia 1 numero inteiro N e uma matriz de ordem N contendo numeros inteiros. Em seguida mostrar a diagonal principal e a quantidade de valores negativos na matriz.

        System.out.println("Insira um numero de 1 a 10: ");
        int N = sc.nextInt();

        int[][] vet = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                vet[i][j] = sc.nextInt();
            }
        }

        int numNegativos = 0;

        System.out.println("Main diagonal: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (vet[i][j] < 0) {
                    numNegativos++;
                }
                if (vet[i] == vet[j]) {
                    System.out.print(vet[i][j] + " ");

                }
            }
        }

        System.out.println();
        System.out.println("Quantidade de números negativos: " + numNegativos);


    }
}