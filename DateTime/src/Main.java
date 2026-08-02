import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDate d1 = LocalDate.parse("2026-08-02");
        LocalDateTime d2 = LocalDateTime.parse("2026-08-02T16:00");
        Instant d3 = Instant.parse("2026-08-12T16:00:00Z");

        LocalDate pastWeekLocalDate = d1.minusDays(7);
        LocalDate nextWeekLocalDate = d1.plusDays(7);

//        System.out.println("semana passada: " + pastWeekLocalDate);
//        System.out.println("Proxima semana: " + nextWeekLocalDate);
//        System.out.println("Daqui 7 anos: "+ d1.plusYears(7));


        LocalDateTime nextWeekLocalDateTime = d2.plusDays(7);
//        System.out.println(nextWeekLocalDateTime);

//        Instant pastWeekInstant = d3.minus(7, ChronoUnit.DAYS);
//        System.out.println(d3);
//        System.out.println(pastWeekInstant);

        Duration duration1 = Duration.between(d2, nextWeekLocalDateTime);
        System.out.println(duration1.toHours());   // total em horas
        System.out.println(duration1.toMinutes()); // total em minutos
        System.out.println(duration1.getSeconds()); // total em segundos
        System.out.println(duration1.toDays()); // total em dias

        if (d2.isBefore(nextWeekLocalDateTime)) {
            System.out.println("d2 é antes");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // converte para modo de leitura local ou como preferir
        System.out.println(nextWeekLocalDateTime.format(formatter)); // formato de leitura local

        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Sao_Paulo"));
        System.out.println(zdt.format(formatter));


        LocalDate hoje = LocalDate.now();
        LocalDateTime agora = LocalDateTime.now();
        Instant agoraInstant = Instant.now();

        LocalDate data = LocalDate.parse("2026-08-02");
        System.out.println(data.getDayOfWeek());   // sábado
        System.out.println(data.getMonth());       // agosto
        System.out.println(data.getDayOfMonth());  // dia 2
        System.out.println(data.lengthOfMonth());  // dias no mês de agosto (31)


    }
}