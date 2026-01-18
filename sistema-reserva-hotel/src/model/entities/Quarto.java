/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import model.enums.Estado;
import model.enums.Tipo;

/**
 *
 * @author jorge-victor
 */
public class Quarto {
    
    private Integer numeroQrt;
    private Integer capacidade;
    private double precoDiarioBase;
    private Tipo tipo;
    private Estado estado;

    public Quarto() {
    }
    
    public Quarto(Integer numqrt,double precoDiarioBase, Tipo tipo, int capacidade, Estado estado) {
        this.numeroQrt = numqrt;
        this.precoDiarioBase = precoDiarioBase;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado)
    {
        this.estado = estado;
    }

    public int getNumero() {
        return numeroQrt;
    }

    public void setNumero(int numero) {
        this.numeroQrt = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getPrecoDiarioBase() {
        return precoDiarioBase;
    }

    public void setPrecoDiarioBase(double precoDiarioBase) {
        this.precoDiarioBase = precoDiarioBase;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.numeroQrt;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Quarto other = (Quarto) obj;
        return this.numeroQrt == other.numeroQrt;
    }

    @Override
    public String toString() {
        return "Quarto{" + "numeroQrt=" + numeroQrt + ", capacidade=" + capacidade + ", precoDiarioBase= " + precoDiarioBase + ", tipo=" + tipo + ", estado=" + estado + '}';
    }
    
    
    
}
