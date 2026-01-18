/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.time.LocalDate;
import java.util.List;
import model.entities.Reserva;
import model.enums.EstadoReserva;

/**
 *
 * @author jorge-victor
 */
public interface ReservaDao {

    void insert(Reserva r);

    Reserva findByCodigo(int codigo);

    List<Reserva> findAll();

    void updateDatas(int codigo, LocalDate dataCheckin, LocalDate dataCheckout);

    void updateEstado(int codigo, EstadoReserva estado);
    
}
