/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.util.List;
import entities.Employee;
import java.util.Scanner;
import java.util.stream.Collectors;
import utils.FileManager;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Employee> employees = FileManager.readFile();

        System.out.print("Enter a salary: ");
        double salary = scan.nextDouble();

        List<String> employeesEmail = employees.stream()
                .filter(e -> e.getSalary() > salary)
                .map(e -> e.getEmail()).sorted()
                .collect(Collectors.toList());

        System.out.println("Email of people whose salary is more than 2000.00:");
        employeesEmail.forEach(System.out::println);

        double sum = employees.stream()
                .filter(e -> e.getName().startsWith("M"))
                .map(p -> p.getSalary())
                .reduce(0.0, (x, y) -> x + y);

        System.out.println("Sum of salary of people whose name starts with 'M': " + sum);

    }
}
