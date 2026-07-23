
import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rent[] quartos = new Rent[10];

        System.out.print("How many rooms will be rented ? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("Rent " + (i) + "º");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Room: ");
            int quarto = sc.nextInt();
            sc.nextLine();

            Rent rent = new Rent(name, email);
            quartos[quarto] = rent;

        }

        System.out.println("Busy rooms: ");
        for (int i = 0; i < 10; i++) {
            if (quartos[i] != null) {
                System.out.println((i)+": " + quartos[i]);
            }
        }

        sc.close();

    }
}