/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author jorge-victor
 */
public class Caixa {

    private static int idCounter = 1;

    private int idCaixa;
    private Queue<Client> clientQueue;
    private int clientesAtendidos;
    private double tempoTotalAtendimento;
    private double tempoMedioAtendimento;
    private double tempoRestante;

    public Caixa() {

        this.idCaixa = idCounter++;
        this.clientQueue = new ArrayDeque<>();
        this.clientesAtendidos = 0;
        this.tempoTotalAtendimento = 0.0;
        this.tempoRestante = 0.0;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }

    public double getTempoTotalAtendimento() {

        return tempoTotalAtendimento;
    }

    public void setTempoTotalAtendimento(int tempoAtendimento) {
        tempoTotalAtendimento = tempoAtendimento;

    }

    public void setClientesAtendidos(int clientesAtendidos) {
        this.clientesAtendidos = clientesAtendidos;
    }

    public double getTempoMedioAtendimento() {
        if (clientesAtendidos == 0) {
            return 0;
        }
        return tempoMedioAtendimento;
    }

    public double getTempoRestante() {
        return tempoRestante;
    }

    public void setTempoRestante(double tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

    public void calcularTempoMedioAtendimento() {
        if (clientesAtendidos == 0) {
            System.out.println("Ainda nao foi atendido nenhum cliente");
        }
        tempoMedioAtendimento = tempoTotalAtendimento / clientesAtendidos;
    }

    public Queue<Client> getFila() {
        return clientQueue;
    }

    public void addClient(Client client) {
        clientQueue.add(client);
    }

    public Integer numeroClientesFila() {
        return clientQueue.size();
    }

    public void atenderCliente(double tempoUsado) {

        Client client = clientQueue.poll(); // remove cliente do topo da fila

        clientesAtendidos++;

        // aumenta o contador de clientes atendidos
        tempoTotalAtendimento += tempoUsado;  // soma o tempo deste atendimento ao total
        // Recalcula tempo médio
        calcularTempoMedioAtendimento();
    }

    @Override
    public String toString() {
        return "Caixa: " + idCaixa + "\nclientQueue: " + clientQueue.size() + ", clientesAtendidos: " + clientesAtendidos + ", tempoTotalAtendimento: " + tempoTotalAtendimento + ", tempoMedioAtendimento:" + tempoMedioAtendimento + ", tempoRestante: " + tempoRestante;
    }
}
