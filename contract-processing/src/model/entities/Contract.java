/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author jorge-victor
 */
public class Contract {

    private Integer numberContract;
    private LocalDate dateContract;
    private Double totalValue;
    private ArrayList<Installment> installments;

    public Contract(Integer numberContract, LocalDate dateContract, Double totalValue) {
        this.numberContract = numberContract;
        this.dateContract = dateContract;
        this.totalValue = totalValue;
        installments = new ArrayList<>();
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(Integer numberContract) {
        this.numberContract = numberContract;
    }

    public LocalDate getDateContract() {
        return dateContract;
    }

    public void setDateContract(LocalDate dateContract) {
        this.dateContract = dateContract;
    }

    public ArrayList<Installment> getInstallments() {
        return installments;
    }

    public void addInstallments(Installment installment) {
        installments.add(installment);
    }
}
