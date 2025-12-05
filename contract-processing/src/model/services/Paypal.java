/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

/**
 *
 * @author jorge-victor
 */
public class Paypal implements OnlineServicePayment {

    private static final double FEE_PERCENTAGE = 0.02;
    private static final double MONTHLY_INTEREST = 0.01;

    @Override
    public Double paymentFee(Double amount) {
        return amount * FEE_PERCENTAGE;
    }

    @Override
    public Double interest(Double amount, Integer month) {
        return amount * month * MONTHLY_INTEREST;
    }

}
