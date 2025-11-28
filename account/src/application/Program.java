/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.util.Scanner;
import model.entities.Account;
import model.exceptions.DepositException;
import model.exceptions.WithDrawException;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("ENTER ACCOUNT DATA");

            System.out.print("Number: ");
            int number = Integer.parseInt(scan.nextLine());

            System.out.print("Holder: ");
            String holder = scan.nextLine();

            System.out.print("Inicial Balance: ");
            Double inicialBalance = scan.nextDouble();

            System.out.print("Withdraw limit: ");
            Double withdrawLimit = scan.nextDouble();

            Account account = new Account(number, holder, inicialBalance, withdrawLimit);

            System.out.print("ENTER AMOUNT FOR WITHDRAW: ");
            double amount = scan.nextDouble();

            account.withdraw(amount);
            
        } catch (WithDrawException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DepositException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
