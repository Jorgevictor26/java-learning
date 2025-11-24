/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import entities.Employee;
import entities.OutsourcedEmployee;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Employee> listOfemployees = new ArrayList<>();

        System.out.println("Enter the number of employess: ");
        int n = scan.nextInt();

        scan.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.printf("\nEmployee #%d data:", i + 1);

            System.out.print("Outsourced(y/n)? ");
            char answer = scan.next().charAt(0);

            scan.nextLine();
            System.out.print("Name: ");
            String name = scan.nextLine();

            System.out.print("Hours: ");
            int hours = scan.nextInt();

            System.out.print("Value per hour: ");
            double valuePerHour = scan.nextDouble();

            if (answer == 'Y' || answer == 'y') {

                System.out.print("\nAdditional charge: ");
                double additionalCharge = scan.nextDouble();

                listOfemployees.add(new OutsourcedEmployee(additionalCharge, name, hours, valuePerHour));
            } else {
                listOfemployees.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println("\nPAYMENTS: ");
        for (Employee emp : listOfemployees) {
            System.out.println(emp.getName() + " - " + "kz " + String.format("%.2f", emp.getValuePerHour()));
        }
        scan.close();
    }
}
