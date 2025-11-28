/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import model.exceptions.DepositException;
import model.exceptions.WithDrawException;

/**
 *
 * @author jorge-victor
 */
public class Account {

    private Integer number;
    private String holder;
    private double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws DepositException {
        this.number = number;
        this.holder = holder;
        this.withdrawLimit = withdrawLimit;
        deposit(balance);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(Double amount) throws DepositException {
        if(amount <= 0)
            throw new DepositException("U must have a inicial balance");
            
        balance += amount;
    }

    public void withdraw(Double amount) throws WithDrawException {

        if (amount <= 0 || amount > balance) {
            throw new WithDrawException("Not enough balance");
        }
        if (amount > withdrawLimit) {
            throw new WithDrawException("The amount exceeds withdraw limit");
        }

        balance -= amount;
        System.out.println("NEW BALANCE: " + balance);
    }

}
