import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate now = LocalDate.now();

        System.out.print("Número do quarto: ");
        int quarto = sc.nextInt();
        sc.nextLine();
        System.out.print("Data de check-in (DD/MM/YYYY): ");
        LocalDate checkIn = LocalDate.parse(sc.nextLine(), dtf);
        System.out.print("Data de check-out (DD/MM/YYYY): ");
        LocalDate checkOut = LocalDate.parse(sc.nextLine(), dtf);

        if (!checkOut.isAfter(checkIn)) {
            System.out.println("Erro na reserva: O check-out deve ser posterior ao check-in");
        }if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
            System.out.println("As datas para reserva devem ser datas futuras.");
        }
        else {
            Reservation reserva = new Reservation(quarto, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
            System.out.println();
            System.out.println("Insira uma nova data para atualizar a reserva: ");
            System.out.print("Data de check-in (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(sc.nextLine(), dtf);
            System.out.print("Data de check-out (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(sc.nextLine(), dtf);

            String erro = reserva.atualizaCheckIn(checkIn, checkOut);
            if (erro != null) {
                System.out.println("Erro na reserva: " + erro);
            } else {
                System.out.println("Reserva: " + reserva);
            }
        }
        sc.close();
    }
}