import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira a quantidade de linhas: ");
        int linhas = sc.nextInt();
        System.out.println("Insira a quantidade de colunas: ");
        int colunas = sc.nextInt();

        int[][] matriz = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        System.out.println("Digite o numero que deseja encontrar e te mostrarei os seu \"vizinhos\". ");
        int x =  sc.nextInt();

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (matriz[i][j] == x) {
                    System.out.println("posição: " + i + ", " + j);
                    if (j > 0){
                        System.out.println("esquerda: " + matriz[i][j - 1]);
                    }
                    if (j < colunas - 1){
                        System.out.println("direita: " + matriz[i][j + 1]);
                    }
                    if (i > 0){
                        System.out.println("Acima: " + matriz[i - 1][j]);
                    }
                    if (i < linhas - 1){
                        System.out.println("Abaixo: " + matriz[i + 1][j]);
                    }
                }
            }
            System.out.println();
        }



    }
}