package services;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {

        Double amountInstallment = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            LocalDate date = contract.getDate().plusMonths(i);
            Double interest = onlinePaymentService.interest(amountInstallment, i);
            Double fee = onlinePaymentService.paymentFee(amountInstallment + interest);
            Double finalInstallment = amountInstallment + interest + fee;
            contract.addInstallment(new Installment(date, finalInstallment));
        }

    }

}