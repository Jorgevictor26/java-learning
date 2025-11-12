/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex01;

import java.util.Scanner;

/**
 *
 * @author jorge-victor
 */
public class ListaNegativos {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Quantos numeros queres digitar?");
        System.out.print("R: ");
        int tamArray = scan.nextInt();

        int[] array = new int[tamArray];

        for (int i = 0; i < array.length; i++) {
            System.out.printf("Digite o %do numero: ", (i + 1));
            array[i] = scan.nextInt();
        }

        System.out.println("Numeros negativos: ");

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                System.out.println(array[i]);
            }
        }

        scan.close();
    }
}
