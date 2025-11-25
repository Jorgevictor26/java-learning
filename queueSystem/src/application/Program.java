/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.util.Scanner;
import modes.AutomaticMode;
import modes.ManualMode;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int option = -1;

        System.out.println("=== Simulacao de Supermercado ===");

        while (option != 0) {

            System.out.println("\nEscolha o modo de simulacao:");
            System.out.println("1 - Modo Manual");
            System.out.println("2 - Modo Automatico");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            option = Integer.parseInt(scan.nextLine());

            switch (option) {
                case 1 -> {
                    ManualMode manual = new ManualMode();
                    manual.iniciarSimulacao();
                }
                case 2 -> {
                    AutomaticMode automatic = new AutomaticMode();
                    automatic.iniciarSimulacao();
                }
                case 0 ->
                    System.out.println("Programa encerrado.");
                default ->
                    System.out.println("Opcao invalida!");
            }
        }

        scan.close();
    }
}
