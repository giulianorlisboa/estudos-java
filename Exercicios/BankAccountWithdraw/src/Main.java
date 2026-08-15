import entities.Account;
import exceptions.InsufficientBalanceException;
import exceptions.NegativeAmountException;
import exceptions.WithdrawLimitExceededException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Insira os dados da conta:");
            System.out.print("Numero: ");
            Integer num = sc.nextInt();
            sc.nextLine();
            System.out.print("Titular: ");
            String holder = sc.nextLine();
            System.out.print("Deposito inicial: ");
            Double balance = sc.nextDouble();
            sc.nextLine();
            System.out.print("Limite de saque: ");
            Double limit = sc.nextDouble();
            sc.nextLine();
            Account acc = new Account(num, holder, balance, limit);
            System.out.println();
            System.out.print("Insira o valor do saque: ");
            Double withdraw = sc.nextDouble();
            sc.nextLine();
            acc.withdraw(withdraw);
            System.out.print("Novo saldo: $" + String.format("%.2f", acc.getBalance()));
        }
        catch (IllegalArgumentException e) {
            System.out.println("Erro de depósito: " + e.getMessage());
        }
        catch (NegativeAmountException e) {
            System.out.println("Erro de saque: " + e.getMessage());
        }
        catch (WithdrawLimitExceededException e) {
            System.out.println("Limite excedido: " + e.getMessage());
        }
        catch (InsufficientBalanceException  e) {
            System.out.println("Saldo insuficiente: " + e.getMessage());
        }

    }
}