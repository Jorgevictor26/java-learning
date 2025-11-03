/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge-victor
 */
import java.util.Scanner;

public class Soma {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        int num1 = scan.nextInt();

        System.out.print("Digite o segundo numero: ");
        int num2 = scan.nextInt();

        int soma = num1 + num2;

        System.out.printf("A soma de %d + %d = %d\n", num1, num2, soma);
    }
}
