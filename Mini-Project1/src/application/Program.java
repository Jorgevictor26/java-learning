/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import model.DadosCorrida;
import service.CalcularPrecoCorrida;
import utils.FileManager;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String args[]) {
        DadosCorrida dados = FileManager.readData();

        double preco = CalcularPrecoCorrida.calcularPreco(dados);
        double precoFinal = CalcularPrecoCorrida.arredondar(preco);

        System.out.println("Preço final da corrida: "
                + CalcularPrecoCorrida.formatar(precoFinal));
    }
}
