/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import model.enums.EstadoPagamento;
import model.enums.EstadoReserva;
import model.enums.FormaCobranca;
import model.enums.Metodo;
import model.enums.TipoServico;
import model.exceptions.BussinessException;

/**
 *
 * @author jorge-victor
 */
public class Reserva {

    private static int idReserva = 1;

    private int CodigoReserva;
    private int qtidadeHospedes;
    private EstadoReserva estadoReserva;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private LocalDateTime dataCriacao;
    private Cliente cliente;
    private Quarto quarto;
    private ArrayList<Payment> pagamentos;
    private ArrayList<ServicoAdicional> servicosAdicionais;

    public Reserva(int qtidadeHospedes, LocalDate dataCheckIn,
            LocalDate dataCheckOut, Cliente cliente, Quarto quarto) {

        verificarData(dataCheckIn, dataCheckOut);
        verificarQtidadeHospedides();

        this.CodigoReserva = idReserva++;

        this.qtidadeHospedes = qtidadeHospedes;
        this.estadoReserva = EstadoReserva.CRIADA;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.dataCriacao = LocalDateTime.now();
        this.cliente = cliente;
        this.quarto = quarto;
        pagamentos = new ArrayList<>();
        servicosAdicionais = new ArrayList<>();
    }

    public int getCodigoReserva() {
        return CodigoReserva;
    }

    public int getQtidadeHospedes() {
        return qtidadeHospedes;
    }

    public void setQtidadeHospedes(int qtidadeHospedes) {
        this.qtidadeHospedes = qtidadeHospedes;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estado) {
        this.estadoReserva = estado;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(LocalDate dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(LocalDate dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Payment> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(ArrayList<Payment> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public ArrayList<ServicoAdicional> getServicosAdicionais() {
        return servicosAdicionais;
    }

    public void setServicosAdicionais(ArrayList<ServicoAdicional> servicosAdicionais) {
        this.servicosAdicionais = servicosAdicionais;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public void addServico(ServicoAdicional servico) {
        servicosAdicionais.add(servico);
    }

    public void registarPagamento(double valor, Metodo metodo) {
        Payment novoPagamento = new Payment(valor, LocalDateTime.now(), metodo, EstadoPagamento.CONFIRMADO);

        this.pagamentos.add(novoPagamento);

        if (this.getSaldo() <= 0) {
            this.estadoReserva = EstadoReserva.CONFIRMADA;
        }
    }

    public void actualizarDataReserva(LocalDate dataCheckIn, LocalDate dataCheckOut) {
        verificarData(dataCheckIn, dataCheckOut);
        setDataCheckIn(dataCheckIn);
        setDataCheckOut(dataCheckOut);
    }

    public void addServico(double preco, int quantidade, TipoServico tipo, FormaCobranca formaCobranca) {

        ServicoAdicional servico = new ServicoAdicional(preco, quantidade, tipo, formaCobranca);
        servicosAdicionais.add(servico);
    }

    public void fazerCheckIn() {
        if (this.estadoReserva == EstadoReserva.CONFIRMADA) {
            this.estadoReserva = EstadoReserva.CHECKED_IN;
        } else {
            System.out.println("Error: So pode fazer check-in de reservas CONFIRMADAS.");
        }
    }

    public void fazerCheckOut() {
        if (this.estadoReserva != EstadoReserva.CHECKED_IN) {
            throw new BussinessException("Deve fazer checkIn");
        } else {
            if (getSaldo() > 0) {
                System.out.println("Aviso: Cliente tem divida: " + getSaldo());
            }

            this.estadoReserva = EstadoReserva.CHECKED_OUT;
            System.out.println("Check-out realizado. Quarto liberado.");
        }
    }

    private long getQtidadeNoites() {
        return ChronoUnit.DAYS.between(dataCheckOut, dataCheckIn);
    }

    private double getSubTotalHospedam() {
        return getQtidadeNoites() * quarto.getPrecoDiarioBase();
    }

    public double getValorHospedagem() {
        double valor = 0.0;
        switch (quarto.getTipo()) {
            case STANDARD -> {
                valor = getSubTotalHospedam() * 1.00;
            }
            case DELUXE -> {
                valor = getSubTotalHospedam() * 1.15;
            }
            case SUITE -> {
                valor = getSubTotalHospedam() * 1.30;
            }
            default -> {
                System.out.println("Opcao Invalida");
            }
        }
        return valor;
    }

    public double getTotalReserva() {

        double totalServicos = servicosAdicionais.stream()
                .mapToDouble(s -> s.getTotalServico(getQtidadeNoites()))
                .sum();

        return getValorHospedagem() + totalServicos;
    }

    public double getTotalPago() {
        return pagamentos.stream()
                .filter(p -> p.getEstadoPagamento() == EstadoPagamento.CONFIRMADO)
                .mapToDouble(p -> p.getValorPago())
                .sum();
    }

    public double getSaldo() {
        return getTotalReserva() - getTotalPago();
    }

    public void cancelar() {
        if (estadoReserva == EstadoReserva.CRIADA
                || estadoReserva == EstadoReserva.CONFIRMADA) {
            throw new BussinessException("Nao pode cancelar\nEstado: " + this.estadoReserva);
        }
        this.estadoReserva = EstadoReserva.CANCELADA;
    }

    public boolean isTotalmentePago(double valorReserva) {
        return getTotalPago() >= valorReserva;
    }

    private void verificarData(LocalDate dataCheckIn, LocalDate dataCheckOut) {

        LocalDate dataActual = LocalDate.now();

        if (dataCheckIn.isBefore(dataActual) || dataCheckOut.isBefore(dataActual)) {
            throw new BussinessException("A data de reserva invalida, deve ser superior a data actual!!");
        }
        if (dataCheckIn.isAfter(dataCheckOut)) {
            throw new BussinessException("A data de checkIn deve ser menor que a data de checkout");
        }
    }

    private void verificarQtidadeHospedides() {
        if (getQtidadeHospedes() > quarto.getCapacidade()) {
            throw new BussinessException("Nao pode passar a capacidade maxima!");
        }
    }

    @Override
    public String toString() {
        return "Reserva" + "CodigoReserva:" + CodigoReserva + ", qtidadeHospedes=" + qtidadeHospedes
                + "" + ", estadoReserva=" + estadoReserva + ", dataCheckIn=" + dataCheckIn + ", dataCheckOut="
                + dataCheckOut + ", dataCriacao=" + dataCriacao + ", Noites: " + getQtidadeNoites() + ", cliente=" + cliente + ", pagamentos="
                + pagamentos + ", servicosAdicionais=" + servicosAdicionais + ", quartoN=" + quarto + ", quarto=" + quarto;
    }

}
