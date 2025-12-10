/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jorge-victor
 */
public class DadosCorrida {

    private int precoBase;
    private int precoPorKm;
    private int oferta;
    private int demanda;
    private int distancia;
    private int hora;

    private boolean clima;
    private boolean transito;
    private boolean evento;

    public int getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(int precoBase) {
        this.precoBase = precoBase;
    }

    public int getPrecoPorKm() {
        return precoPorKm;
    }

    public void setPrecoPorKm(int precoPorKm) {
        this.precoPorKm = precoPorKm;
    }

    public int getOferta() {
        return oferta;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }

    public int getDemanda() {
        return demanda;
    }

    public void setDemanda(int demanda) {
        this.demanda = demanda;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public boolean isClima() {
        return clima;
    }

    public void setClima(boolean clima) {
        this.clima = clima;
    }

    public boolean isTransito() {
        return transito;
    }

    public void setTransito(boolean transito) {
        this.transito = transito;
    }

    public boolean isEvento() {
        return evento;
    }

    public void setEvento(boolean evento) {
        this.evento = evento;
    }

    public double getOfertaPorDemanda() {
        return (double) oferta / demanda;
    }
}
