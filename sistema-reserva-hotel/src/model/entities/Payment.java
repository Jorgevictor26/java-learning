/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import model.services.*;
import java.time.LocalDateTime;
import model.enums.EstadoPagamento;
import model.enums.Metodo;

/**
 *
 * @author jorge-victor
 */
public class Payment {

    private double valorPago;
    private LocalDateTime dataPagamento;
    private Metodo metodo;
    private EstadoPagamento estadoPagamento;

    public Payment(double valorPago, LocalDateTime dataPagamento, Metodo metodo, EstadoPagamento estadoPagamento) {
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.metodo = metodo;
        this.estadoPagamento = estadoPagamento;
    }

    public Payment() {
        this.estadoPagamento = EstadoPagamento.PENDENTE;
    }

    public EstadoPagamento getEstadoPagamento() {
        return estadoPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public Metodo getMetodo() {
        return metodo;
    }
}
