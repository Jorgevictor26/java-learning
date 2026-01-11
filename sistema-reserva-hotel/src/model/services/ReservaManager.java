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
import model.enums.EstadoReserva;
import model.exceptions.QuartoException;

/**
 *
 * @author jorge-victor
 */
public class ReservaManager {

    private ArrayList<Reserva> reservas = new ArrayList<>();

    public void criarReserva(int qtidadeHospedes, LocalDate dataCheckIn,
            LocalDate dataCheckOut, Cliente cliente, Quarto quarto) {

        verificarSobrePosicao(quarto, dataCheckIn, dataCheckOut);
        Reserva reserva = new Reserva(qtidadeHospedes, dataCheckIn, dataCheckOut, cliente, quarto);

        addReserva(reserva);

    }

    private void verificarSobrePosicao(Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        for (Reserva r : reservas) {
            if (r.getQuarto().equals(quarto) && (dataCheckIn.isBefore(r.getDataCheckIn()) && dataCheckOut.isBefore(r.getDataCheckOut()))) {
                throw new QuartoException("Nao pode ter sobreposicao, quarto reservado para esse periodo");
            }
        }
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    private void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void actualizarReserva(int codigo, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        Reserva reserva = null;

        for (Reserva r : reservas) {
            if (r.getCodigoReserva() == codigo) {
                reserva = r;
                break;
            }
        }

        if (reserva == null) {
            System.out.println("Nao encontrada");
        }
        verificarSobrePosicao(reserva.getQuarto(), dataCheckIn, dataCheckOut);

        reserva.actualizarDataReserva(dataCheckIn, dataCheckOut);
    }

    public void ImprimirReservas() {
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }

    public void confirmarReserva(int codigoReserva) {
        Reserva reserva = null;

        for (Reserva r : reservas) {
            if (r.getCodigoReserva() == codigoReserva) {
                reserva = r;
                break;
            }
        }

        if (reserva == null) {
            System.out.println("Reserva nao encontrada!");
            return;
        }

        if (reserva.getEstadoReserva() != EstadoReserva.CRIADA) {
            System.out.println("A reserva nao pode ser confirmada. Estado atual: " + reserva.getEstadoReserva());
            return;
        }

        reserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
        System.out.println("Reserva confirmada com sucesso!");
    }

    public void cancelarReserva(int codigo) {
        Reserva reserva = null;

        for (Reserva r : reservas) {
            if (r.getCodigoReserva() == codigo) {
                reserva = r;
                break;
            }
        }

        if (reserva == null) {
            System.out.println("Nao encontrada");
        }

        if (!reserva.podeSerCancelada()) {
            System.out.println("Nao pode ser cancelada");
            //retr«orna exception
        }

        reserva.cancelar();
    }

    public void processarCheckIn(int id) {
        for (Reserva r : reservas) {
            if (r.getCodigoReserva() == id) {
                r.fazerCheckIn();
                return;
            }
        }
        System.out.println("Reserva com ID " + id + " não encontrada.");
    }

}
