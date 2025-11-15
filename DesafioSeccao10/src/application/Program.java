/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author jorge-victor
 */
import entities.Estudante;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        final int TAM = 10;
        Scanner scan = new Scanner(System.in);
        Estudante[] arrayEstudantes = new Estudante[TAM];

        System.out.print("Quantos qrts qrs alugar: ");
        int qtidadeQrts = scan.nextInt();

        for (int i = 0; i < qtidadeQrts; i++) {
            scan.nextLine();

            System.out.printf("Rent #%d%n", (i + 1));

            System.out.print("Nome: ");
            String nome = scan.nextLine();

            System.out.print("Email: ");
            String email = scan.nextLine();

            System.out.print("Numero do Quarto: ");
            int numDoQrt = scan.nextInt();

            System.out.println("");

            if (arrayEstudantes[numDoQrt] == null) {

                arrayEstudantes[numDoQrt] = new Estudante(nome, email);

            } else {

                System.out.printf("QUARTO [%d] OCUPADO", numDoQrt);
            }
        }

        System.out.print("\nQUARTOS OCUPADOS:\n");

        for (int i = 0; i < arrayEstudantes.length; i++) {

            if (arrayEstudantes[i] != null) {
                System.out.println(i + " : " + arrayEstudantes[i]);
            }
        }

        scan.close();
    }
}
