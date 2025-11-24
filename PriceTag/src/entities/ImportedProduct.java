/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author jorge-victor
 */
public class ImportedProduct extends Product {

    private Double customsFee;

    public ImportedProduct(Double customsFee, String name, Double price) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    public Double totalPrice() {
        return price + getCustomsFee();
    }

    @Override
    public String priceTag() {
        return name + " $ " + String.format("%.2f", totalPrice()) + "(Customs fee: $ " + String.format("%.2f", customsFee) + ")";
    }
}
