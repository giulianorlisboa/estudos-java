package model.entities;

import model.exceptions.DomainException;

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
        if (checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
            throw new DomainException("As datas para reserva devem ser datas futuras.");
        }
        if(!checkOut.isAfter(checkIn)){
            throw new DomainException("O check-out deve ser posterior ao check-in");
        }
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

    public void atualizarReserva(LocalDate checkIn, LocalDate checkOut) {
        if (checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
            throw new DomainException("As datas para reserva devem ser datas futuras.");
        }
        if(!checkOut.isAfter(checkIn)){
            throw new DomainException("O check-out deve ser posterior ao check-in");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Quarto " +
                numeroDoQuarto
                +", check-in: "
                + checkIn.format(fmt)
                +", check-out: "
                + checkOut.format(fmt)
                +", "
                + duracao()
                +" noites";
    }
}
