/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import entities.Pacote;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helena Panzo
 */
public class CalcularCargaIdeal {

    public static ArrayList<Pacote> selecionarPacotes(ArrayList<Pacote> pacotes, int capacidade) {

        int n = pacotes.size();
        int W = capacidade;

        double[][] dp = new double[n + 1][W + 1];

        // Programação dinâmica 
        for (int i = 1; i <= n; i++) { // loop dos pacotes

            Pacote p = pacotes.get(i - 1);

            for (int j = 0; j <= W; j++) {// loop dos pesos
                if (p.getPeso() <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - p.getPeso()] + p.getValor());
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Reconstruir a solução
        ArrayList<Pacote> selecionados = new ArrayList<>();
        int w = W;
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Pacote p = pacotes.get(i - 1);
                selecionados.add(p);
                w -= p.getPeso();
            }
        }
        return selecionados;
    }

    public static double calcularValorTotal(List<Pacote> pacotes) {
        double total = 0.0;
        for (Pacote p : pacotes) {
            total += p.getValor();
        }
        return total;
    }

    public static int calcularPesoTotal(List<Pacote> pacotes) {
        int pesoTotal = 0;
        for (Pacote p : pacotes) {
            pesoTotal += p.getPeso();
        }
        return pesoTotal;
    }

    public static void imprimirPacotes(ArrayList<Pacote> pacotes) {
        System.out.println("PACOTES SELECCIONADOS:");
        System.out.printf("%-5s %-10s\n", "PESO", "VALOR");
        for (Pacote p : pacotes) {
            System.out.printf("%-2dkg  %-3.2fkz\n", p.getPeso(), p.getValor());
        }
    }

    public static void mostrarTotal(ArrayList<Pacote> pacotes) {
        System.out.println("\nPesoTotal: " + calcularPesoTotal(pacotes) + "kg"
                + "\nLucro: " + String.format("%.2f", calcularValorTotal(pacotes)) + "kz");
    }
}
