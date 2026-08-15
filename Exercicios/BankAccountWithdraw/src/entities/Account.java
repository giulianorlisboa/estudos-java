package entities;

import exceptions.InsufficientBalanceException;
import exceptions.NegativeAmountException;
import exceptions.WithdrawLimitExceededException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = 0.0;
        this.deposit(balance);
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public void deposit(Double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("O valor do depósito não pode ser nulo nem negativo");
        }
        this.balance += amount;
    }

    public void withdraw(Double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException("O valor do saque não pode ser nulo nem negativo");
        }
        if (amount > withdrawLimit) {
            throw new WithdrawLimitExceededException("O valor do saque é maior que o limite permitido.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("O valor do saque é maior que o saldo disponivel.");
        }

        this.balance -= amount;

    }
}
