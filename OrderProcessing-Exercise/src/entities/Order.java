/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import entities.enums.OrderStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author jorge-victor
 */
public class Order {

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;
    private ArrayList<OrderItem> items = new ArrayList<>();

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void addItems(OrderItem item) {
        items.add(item);
    }

    public void removeItems(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        double sum = 0;
        for (OrderItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder dados = new StringBuilder();

        dados.append("ORDER SUMARY: ").append("\n");
        dados.append("Order moment: ").append(moment.format(fmt1)).append("\n");
        dados.append("Order status: ").append(status).append("\n");
        dados.append("Client: ").append(client.getName()).append(" (").append(client.getBirthDate().format(fmt)).append(") ").append(" - ").append(client.getEmail());
        dados.append("\nOrder items:").append("\n");
        for (OrderItem item : items) {
            dados.append(item.product.getName()).append(", $").append(String.format("%.2f", item.getPrice())).append(", Quantity: ").append(item.getQuantity()).append(", Subtotal: ").append(String.format("%.2f\n", item.subTotal()));
        }
        dados.append("Total price: ").append(String.format("%.2f\n", total()));

        return dados.toString();
    }
}
