package services;

public class PaypalService implements OnlinePaymentService{

    public Double paymentFee(Double amount){
        return amount * 0.02;
    }

    public Double interest(Double amount, Integer months){
        Double interest = 0.01 * months;
        return amount + (amount * interest);
    }

}
