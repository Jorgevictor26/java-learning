/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jorge-victor
 */
public class program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.printf("\nProduct #%d data:\n", i + 1);

            System.out.print("Common, used or imported (c/u/i)? ");
            char type = scan.next().charAt(0);
            scan.nextLine();

            System.out.print("Name: ");
            String name = scan.nextLine();

            System.out.print("Price: ");
            double price = scan.nextDouble();
            scan.nextLine();

            if (type == 'i' || type == 'I') {
                
                System.out.print("Customs fee: ");
                double customsFee = scan.nextDouble();
                scan.nextLine(); // limpa buffer

                products.add(new ImportedProduct(customsFee, name, price));

            } else if (type == 'u' || type == 'U') {
                
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String date = scan.nextLine();

                LocalDate date1 = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                products.add(new UsedProduct(date1, name, price));

            } else if (type == 'c' || type == 'C') {
                
                products.add(new Product(name, price));

            } else {
                System.out.println("Invalid Option!!");
            }

        }
            System.out.println("\nPRICE TAGS: ");
        for (Product product : products) {
            System.out.println(product.priceTag());
        }

        scan.close();
    }
}
