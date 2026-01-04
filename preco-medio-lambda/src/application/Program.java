/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import entities.Product;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import services.ProductService;
import utils.FileManager;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {

        List<Product> products = FileManager.readFile();

        double average = ProductService.productAverage(products);

        List<String> productsName = products.stream()
                .filter(p -> p.getPrice() < average)
                .map(p -> p.getName()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println("Average price: " + String.format("%.2f", average));
        productsName.forEach(System.out::println);
    }
}
