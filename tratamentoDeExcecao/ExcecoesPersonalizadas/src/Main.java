import model.entities.Reservation;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Número do quarto: ");
            int quarto = sc.nextInt();
            sc.nextLine();
            System.out.print("Data de check-in (DD/MM/YYYY): ");
            LocalDate checkIn = LocalDate.parse(sc.nextLine(), dtf);
            System.out.print("Data de check-out (DD/MM/YYYY): ");
            LocalDate checkOut = LocalDate.parse(sc.nextLine(), dtf);

            Reservation reserva = new Reservation(quarto, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
            System.out.println();

            System.out.println("Insira uma nova data para atualizar a reserva: ");
            System.out.print("Data de check-in (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(sc.nextLine(), dtf);
            System.out.print("Data de check-out (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(sc.nextLine(), dtf);

            reserva.atualizarReserva(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
        }
        catch(DateTimeParseException e){
            System.out.println("Formato de data inválida.");
        }
        catch (DomainException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Erro inesperado.");
        }
        sc.close();
    }
}
