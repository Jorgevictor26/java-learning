/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

import java.time.LocalDateTime;
import model.entities.Payment;
import model.entities.Reserva;
import model.enums.EstadoPagamento;
import model.enums.Metodo;

/**
 *
 * @author jorge-victor
 */
public class PagamentoManager {

    public void pagar(Reserva reserva, double valor, Metodo metodo) {
        Payment p = new Payment(valor, LocalDateTime.now(), metodo, EstadoPagamento.PENDENTE);
        reserva.addPagamento(p);
    }

    public void listarPagamentos(Reserva reserva) {
        for (Payment p : reserva.getPagamentos()) {
            System.out.println(p);
        }
    }
}
