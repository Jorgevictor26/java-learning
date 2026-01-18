/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.io.Serializable;
import java.util.Objects;
import model.exceptions.BusinessException;

/**
 *
 * @author jorge-victor
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer number;
    private String holder;
    private double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws BusinessException {
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

    public void deposit(Double amount) throws BusinessException {
        if (amount <= 0) {
            throw new BusinessException("U must have a inicial balance");
        }

        balance += amount;
    }

    public void withdraw(Double amount) {
        validateWithdraw(amount);
        balance -= amount;
    }

    private void validateWithdraw(Double amount) throws BusinessException {
        if (amount <= 0 || amount > balance) {
            throw new BusinessException("Not enough balance");
        }
        if (amount > withdrawLimit) {
            throw new BusinessException("The amount exceeds withdraw limit");
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.number);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        return Objects.equals(this.number, other.number);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Account");
        sb.append("number=").append(number);
        sb.append(", holder=").append(holder);
        sb.append(", balance=").append(balance);
        sb.append(", withdrawLimit=").append(withdrawLimit);
        return sb.toString();
    }

}
