/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jorge-victor
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Contribuinte> contribuintes = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        System.out.print("ENTER THE NUMBER OF TAX PAYERS: ");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("\nTax payer #%d data", i + 1);

            System.out.print("Individual or company (i/c)? ");
            char typeOfTaxPayer = scan.next().charAt(0);

            scan.nextLine();

            System.out.print("Name: ");
            String name = scan.nextLine();

            System.out.print("Anual income: ");
            double anualIncome = scan.nextDouble();

            if (typeOfTaxPayer == 'i' || typeOfTaxPayer == 'I') {
                System.out.print("Health expenditures: ");

                double healthExpenditures = scan.nextDouble();

                Contribuinte contribuinte = new PessoaFisica(name, anualIncome, healthExpenditures);

                contribuintes.add(contribuinte);
            } else {

                System.out.print("Number of employees: ");
                int numberEmployess = scan.nextInt();

                Contribuinte contribuinte = new PessoaJuridica(name, anualIncome, numberEmployess);

                contribuintes.add(contribuinte);
            }

        }

        System.out.println("TAXES PAID:");

        for (Contribuinte c : contribuintes) {
            System.out.println(c.getNome() + " $ " + String.format("%.2f", c.getImposto()));
        }
    }

}
