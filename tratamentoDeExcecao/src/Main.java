import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        method1();

    }

    public static void method1() {
        System.out.println("inicio metodo 1");
        Scanner sc = new Scanner(System.in);
//        TRY - CATCH

        try {
            String[] vetor = sc.nextLine().split(" ");
            int posicao = sc.nextInt();
            System.out.println(vetor[posicao]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("posição inválida");
            e.printStackTrace();
            sc.next();
        } catch (InputMismatchException e) {
            System.out.println("Erro de inserção");
        }

        System.out.println("Fim do metodo 1");

        System.out.println("inicio metodo 2");
        File arquivo = new File("C:\\temp\\in.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Erro ao abrir o arquivo " + e.getMessage());
        }
        finally {
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner fechado");
            }
        }
        System.out.println("Fim do metodo 2");
    }

}
