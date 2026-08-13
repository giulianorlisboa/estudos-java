import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int quarto = sc.nextInt();
        sc.nextLine();
        System.out.print("Data de checkIn (DD/MM/YYYY): ");
        LocalDate checkIn = LocalDate.parse(sc.nextLine(), dtf);
        System.out.print("Data de checkOut (DD/MM/YYYY): ");
        LocalDate checkOut = LocalDate.parse(sc.nextLine(), dtf);

        if(!checkOut.isAfter(checkIn)){
            System.out.println("Erro na reserva: O checkOut deve ser posterior ao checkIn");
        }
        else {
            Reservation reserva = new Reservation(quarto,checkIn,checkOut);
            System.out.println("Reserva: " + reserva);
            System.out.println();
            System.out.println("Insira uma nova data para atualizar a reserva: ");
            System.out.print("Data de checkIn (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(sc.nextLine(), dtf);
            System.out.print("Data de checkOut (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(sc.nextLine(), dtf);

            LocalDate now = LocalDate.now();
            if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
                System.out.println("Erro de reserva: As datas para reserva devem ser datas futuras.");
            }
            else if(!checkOut.isAfter(checkIn)){
                System.out.println("Erro na reserva: O checkOut deve ser posterior ao checkIn");
            }
            else {
                reserva.atualizaCheckIn(checkIn,checkOut);
                System.out.println("Reserva: " + reserva);
            }
        }


        sc.close();
    }
}