/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
Fazer um programa para ler quatro valores inteiros A, B, C e D. A seguir, calcule e mostre a diferença do produto
de A e B pelo produto de C e D segundo a fórmula: DIFERENCA = (A * B - C * D)
 */
import java.util.Scanner;

public class DiferencaProduto {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o numero a: ");
        int a = scan.nextInt();

        System.out.print("Digite o numero a: ");
        int b = scan.nextInt();

        System.out.print("Digite o numero c: ");
        int c = scan.nextInt();

        System.out.print("Digite o numero d: ");
        int d = scan.nextInt();

        int diferenca = ((a * b) - (c * d));

        System.out.printf("A Diferenca de %d e %d pelo produto %d e %d é igual a %d\n", a, b, c, d, diferenca);
    }
}
