/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.text.DecimalFormat;
import model.DadosCorrida;

/**
 *
 * @author jorge-victor
 */
public class CalcularPrecoCorrida {

    private static final double MULTIPLO_ARREDONDAMENTO = 50.0;

    public static double fatorHora(int hora) {

        if (hora >= 12 && hora <= 18) {
            return 1.3;
        }
        if (hora >= 19 && hora <= 23) {
            return 1.4;
        }
        if (hora >= 0 && hora <= 4) {
            return 1.6;
        }
        if (hora >= 5 && hora <= 8) {
            return 1.5;
        }

        return 1.0;
    }

    public static double fatorClima(boolean clima) {
        return clima ? 1.5 : 1.0;
    }

    public static double fatorTransito(boolean transito) {
        return transito ? 1.3 : 1.0;
    }

    public static double fatorEvento(boolean evento) {
        return evento ? 1.5 : 1.0;
    }

    public static double fatorOfertaDemanda(double relacao) {
        if (relacao < 1.0) {
            return 1.5;
        }
        if (relacao == 1.0) {
            return 1.0;
        }
        return 0.8;
    }

    public static double fatorDinamico(DadosCorrida d) {
        return fatorHora(d.getHora())
                * fatorTransito(d.isTransito())
                * fatorEvento(d.isEvento())
                * fatorClima(d.isClima())
                * fatorOfertaDemanda(d.getOfertaPorDemanda());
    }

    public static double calcularPreco(DadosCorrida d) {
        double precoBase = d.getPrecoBase() + (d.getDistancia() * d.getPrecoPorKm());
        return precoBase * fatorDinamico(d);
    }

    public static double arredondar(double valor) {
        return Math.round(valor / MULTIPLO_ARREDONDAMENTO) * MULTIPLO_ARREDONDAMENTO;
    }

    public static String formatar(double valor) {
        DecimalFormat df = new DecimalFormat("#,##0 Kz");
        return df.format(valor);
    }
}
