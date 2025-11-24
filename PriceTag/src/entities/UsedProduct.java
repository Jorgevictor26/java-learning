/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jorge-victor
 */
public class UsedProduct extends Product {

    private LocalDate date;

    public UsedProduct(LocalDate date, String name, Double price) {
        super(name, price);
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String priceTag() {
        return name + " (used) $  " + String.format("%.2f", price) + " (Manufacture date: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")";
    }
}
