/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.time.LocalDate;

/**
 *
 * @author jorge-victor
 */
public class Installment {

    private LocalDate dueData;
    private Double value;

    public Installment(LocalDate dueData, Double value) {
        this.dueData = dueData;
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public LocalDate getDueData() {
        return dueData;
    }
}
