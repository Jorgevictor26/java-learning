/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

import java.time.LocalDate;
import model.entities.Contract;
import model.entities.Installment;

/**
 *
 * @author jorge-victor
 */
public class ContractService {

    private OnlineServicePayment onlineServicePayment;

    public ContractService(OnlineServicePayment onlineServicePayment) {
        this.onlineServicePayment = onlineServicePayment;
    }

    public void processContract(Contract contract, Integer months) {
        double amount = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDateContract().plusMonths(i);
            double interest = onlineServicePayment.interest(amount, i);
            double fee = onlineServicePayment.paymentFee(amount+interest);
            double value = amount+ interest + fee;
            contract.addInstallments(new Installment(dueDate, value));
        }
    }
}
