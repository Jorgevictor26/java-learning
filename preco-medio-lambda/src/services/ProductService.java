/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Product;
import java.util.List;

/**
 *
 * @author jorge-victor
 */
public class ProductService {

    public static double productAverage(List<Product> products) {
        return products.stream()
                .mapToDouble(product -> product.getPrice())
                .average().orElse(0);
    }
}
