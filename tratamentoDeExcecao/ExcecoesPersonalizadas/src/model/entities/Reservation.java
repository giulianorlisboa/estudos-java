package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private Integer numeroDoQuarto;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer numeroDoQuarto, LocalDate checkIn, LocalDate checkOut) {
        this.numeroDoQuarto = numeroDoQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuarto(Integer numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duracao() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public void atualizaCheckIn(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Quarto " +
                numeroDoQuarto
                +", checkIn: "
                + checkIn.format(fmt)
                +", checkOut: "
                + checkOut.format(fmt)
                +", "
                + duracao()
                +" noites";
    }
}
