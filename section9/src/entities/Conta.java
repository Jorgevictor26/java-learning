/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author jorge-victor
 */
public class Conta {

    private String titular;
    private double saldo;
    private int numeroDaConta;

    public Conta(String titular, double depositoInicial, int numeroDaConta) {
        this.titular = titular;
        this.numeroDaConta = numeroDaConta;
        deposito(depositoInicial);
    }

    public Conta(String titular, int numeroDaConta) {
        this.titular = titular;
        this.numeroDaConta = numeroDaConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void deposito(double amount) {
        if (amount < 0) {
            System.out.println("Impossivel realizar depéosito");
        } else {
            saldo += amount;
        }
    }

    public void withdraw(double amount) {
        saldo -= amount + 5.0; // 5 é a taxa de saque
    }

    public String toString() {
        return "Titular: " + titular + "\nSaldo: " + String.format("%.2f", saldo);
    }
}
