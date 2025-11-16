/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex04;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("M: ");
        int M = scan.nextInt();

        System.out.print("N: ");
        int N = scan.nextInt();

        int[][] matrix = new int[M][N];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = rand.nextInt(100);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }

        System.out.print("Digite um numero que esta presente na matriz: ");

        int numero = scan.nextInt();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == numero) {
                    System.out.printf("\nPosition: %d, %d: ", i, j);
                    if (j > 0) {
                        System.out.printf("\nLeft: %d", matrix[i][j - 1]);
                    }
                    if (j < matrix[i].length - 1) {
                        System.out.printf("\nRight: %d", matrix[i][j + 1]);
                    }
                    if (i < matrix.length - 1) {
                        System.out.printf("\nDown: %d\n", matrix[i + 1][j]);
                    }
                }
            }
        }

    }
}
