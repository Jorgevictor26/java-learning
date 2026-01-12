/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

import java.time.LocalDate;
import java.util.ArrayList;
import model.entities.Cliente;
import model.entities.Quarto;
import model.entities.Reserva;
import model.exceptions.BussinessException;

/**
 *
 * @author jorge-victor
 */
public class ReservaManager {

    private ArrayList<Reserva> reservas = new ArrayList<>();

    public Reserva criarReserva(int qtidadeHospedes, LocalDate dataCheckIn,
            LocalDate dataCheckOut, Cliente cliente, Quarto quarto) {

        verificarSobrePosicao(quarto, dataCheckIn, dataCheckOut);

        Reserva reserva = new Reserva(qtidadeHospedes, dataCheckIn, dataCheckOut, cliente, quarto);

        addReserva(reserva);
        return reserva;
    }

    private void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void actualizarReserva(Reserva reserva, LocalDate dataCheckIn, LocalDate dataCheckOut) {

        verificarSobrePosicao(reserva.getQuarto(), dataCheckIn, dataCheckOut);

        reserva.actualizarDataReserva(dataCheckIn, dataCheckOut);
    }

    public void ListarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
            return;
        }
        reservas.forEach(System.out::println);
    }

    public void cancelarReserva(int codigo) {

        Reserva reserva = buscarReserva(codigo);
        if (reserva == null) {
            System.out.println("Reserva nao encontrada");
            return;
        }

        reserva.cancelar();
    }

    public void processarCheckOut(int id) {

        Reserva reserva = buscarReserva(id);
        if (reserva == null) {
            System.out.println("Reserva nao encontrada");
        } else {
            reserva.fazerCheckOut();
        }
    }

    public void processarCheckIn(int id) {
        Reserva reserva = buscarReserva(id);
        if (reserva == null) {
            System.out.println("Reserva nao encontrada");
        } else {
            reserva.fazerCheckIn();
        }
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public Reserva buscarReserva(int codigo) {

        for (Reserva r : reservas) {
            if (r.getCodigoReserva() == codigo) {
                return r;
            }
        }
        return null;
    }

    private void verificarSobrePosicao(Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        for (Reserva r : reservas) {
            if (r.getQuarto().equals(quarto)
                    && dataCheckIn.isBefore(r.getDataCheckOut())
                    && dataCheckOut.isAfter(r.getDataCheckIn())) {
                throw new BussinessException("Conflito de datas: O quarto ocupado neste periodo.");
            }
        }
    }

}
