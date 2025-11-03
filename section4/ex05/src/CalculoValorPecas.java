/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*Fazer um programa para ler o código de uma peça 1, o número de peças 1, o valor unitário de cada peça 1, o
código de uma peça 2, o número de peças 2 e o valor unitário de cada peça 2. Calcule e mostre o valor a ser pago.
 */
import java.util.Scanner;

public class CalculoValorPecas {

   public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o código da primeira peca:");
        int peca1 = scan.nextInt();

        System.out.print("Digite a quantidade da primeira peca:");
        int qtd1 = scan.nextInt();

        System.out.print("Digite o valor unitario da primeira peca:");
        double valor1 = scan.nextDouble();

        System.out.print("Digite o codigo da segunda peca:");
        int peca2 = scan.nextInt();

        System.out.println("Digite a quantidade da segunda peça:");
        int qtd2 = scan.nextInt();

        System.out.println("Digite o valor unitário da segunda peça:");
        double valor2 = scan.nextDouble();

        double total = (qtd1 * valor1) + (qtd2 * valor2);

        System.out.printf("VALOR A PAGAR: %.2fkz%n", total);

        scan.close();
        
    }
}
