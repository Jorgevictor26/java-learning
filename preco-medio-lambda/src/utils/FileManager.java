/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import entities.Product;
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

    public static List<Product> readFile() {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("products.csv"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String parts[] = line.split(",");

                String name = parts[0];
                double price = Double.parseDouble(parts[1]);

                products.add(new Product(name, price));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return products;
    }
}
