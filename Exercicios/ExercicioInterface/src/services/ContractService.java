package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public OnlinePaymentService getOnlinePaymentService() {
        return onlinePaymentService;
    }

    public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {

        Double amountInstallment = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {

            LocalDate date = contract.getDate().plusMonths(i);
            Double interestValue = onlinePaymentService.interest(amountInstallment, i);
            Double installmentFinal = interestValue + onlinePaymentService.paymentFee(interestValue);
            Installment installment = new Installment(date, installmentFinal);
            contract.addInstallment(installment);
        }

    }

}