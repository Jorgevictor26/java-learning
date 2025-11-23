/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LocalDateTime moment = LocalDateTime.now();

        System.out.println("ENTER CLIENT DATA: ");

        System.out.print("Name: ");
        String name = scan.nextLine();

        System.out.print("Email: ");
        String email = scan.nextLine();

        System.out.print("Birth Date (DD/MM/YYYY: ");
        String date = scan.nextLine();

        LocalDate birthDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("\nENTER ORDER DATA: ");
        System.out.print("Status: ");
        String orderStatus = scan.nextLine();

        Order order = new Order(moment, OrderStatus.valueOf(orderStatus), new Client(name, email, birthDate));

        System.out.println("How many items to this order? ");
        int n = scan.nextInt();

        scan.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.printf("\nEnter #%d item data\n", i + 1);

            System.out.print("\nProduct name: ");
            String productName = scan.nextLine();

            System.out.print("Product price:");
            double productPrice = scan.nextDouble();

            System.out.print("Quantity: ");
            int productQuantity = scan.nextInt();
            
            scan.nextLine();

            Product product = new Product(productName, productPrice);

            order.addItems(new OrderItem(productQuantity, productPrice, product));
        }
        System.out.println(" ");
        
        System.out.println(order);

        scan.close();
    }
}
