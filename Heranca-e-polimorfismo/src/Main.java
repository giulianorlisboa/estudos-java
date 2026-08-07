import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;

public class Main
{
    public static void main(String[] args) {
        Account acc = new Account(8210, "Giuliano", 0.0);
        BusinessAccount bacc = new BusinessAccount(8243, "Kelly", 0.0, 500.0);

        //UPCASTING

        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(8265, "Bob", 250.0, 1000.0);
        Account acc3 = new SavingAccount(1654, "Ana", 0.0, 12.0);

        //DOWNCASTING

        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.0);

//        BusinessAccount acc5 = (BusinessAccount) acc3;

//        if (acc3 instanceof BusinessAccount) {
//            BusinessAccount acc5 = (BusinessAccount) acc3;
//            acc5.loan(200.0);
//            System.out.println("Loan!");
//        }
//
//        if (acc3 instanceof SavingAccount) {
//            SavingAccount acc6 = (SavingAccount) acc3;
//            acc6.updateBalance();
//            System.out.println("UPTADE!");
//        }





    }
}