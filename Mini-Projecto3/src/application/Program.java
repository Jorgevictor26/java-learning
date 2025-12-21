/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package application;

import entities.Camiao;
import entities.Pacote;
import java.util.ArrayList;
import utils.FileManager;
import utils.CalcularCargaIdeal;

/**
 *
 * @author Helena Panzo
 */
public class Program {

    public static void main(String[] args) {

        Camiao camiao = new Camiao();

        ArrayList<Pacote> pacotesDisponiveis = FileManager.readFile(camiao);
        ArrayList<Pacote> pacotesSelecionados = CalcularCargaIdeal.selecionarPacotes(pacotesDisponiveis, camiao.getCapacidade());

        System.out.println("Capacidade do camiao: " + camiao.getCapacidade() + " kg\n");
        
        CalcularCargaIdeal.imprimirPacotes(pacotesSelecionados);
        CalcularCargaIdeal.mostrarTotal(pacotesSelecionados);

        FileManager.writeFile(pacotesSelecionados, camiao);

    }
}
