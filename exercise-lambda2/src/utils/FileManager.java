/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import entities.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge-victor
 */
public class FileManager {

    public static List<Employee> readFile() {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String parts[] = line.split(",");

                String name = parts[0];
                String email = parts[1];
                double salary = Double.parseDouble(parts[2]);

                employees.add(new Employee(name, email, salary));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return employees;
    }
}
