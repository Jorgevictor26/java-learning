/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author jorge-victor
 */
public class program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String departmentName = scan.nextLine();

        System.out.println("\nENTER WORKER DATA:");

        System.out.print("\nName: ");
        String name = scan.nextLine();
        System.out.print("\nLevel: ");
        String workLevel = scan.nextLine();
        System.out.print("\nBase Salary: ");
        double baseSalary = scan.nextDouble();

        Worker worker = new Worker(name, WorkerLevel.valueOf(workLevel), baseSalary, new Department(departmentName));

        System.out.print("\nHow many contracts to this worker? ");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {

            scan.nextLine();

            System.out.printf("\nEnter contract #%d data:\n", i + 1);

            System.out.print("\nDate (DD/MM/YYYY): ");
            String data = scan.nextLine();
            LocalDate date = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.print("\nValue per hour: ");
            double valuePerHour = scan.nextDouble();

            System.out.print("\nDuration(hours): ");
            int hours = scan.nextInt();

            worker.addContract(new HourContract(date, valuePerHour, hours));
        }

        scan.nextLine();

        System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
        String entrymonthAndYear = scan.nextLine();

        String[] monthAndYear = entrymonthAndYear.split("/");

        int month = Integer.parseInt(monthAndYear[0]);
        int year = Integer.parseInt(monthAndYear[1]);

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + entrymonthAndYear + " : " + String.format("%.2f", worker.income(year, month)));

// tirar o mes usando substring  int month = Integer.parseInt(monthAndYear.substring(0, 2)); 
//        int year = Integer.parseInt(monthAndYear.substring(3, 6));
    }
}
