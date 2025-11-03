/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge-victor
 */
import java.util.Scanner;
public class CalcularAreas {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o valor de A:");
        double a = scan.nextDouble();

        System.out.print("Digite o valor de B:");
        double b = scan.nextDouble();

        System.out.print("Digite o valor de C:");
        double c = scan.nextDouble();

        double pi = 3.14159;

        double areaTriangulo = (a * c) / 2.0;

        double areaCirculo = pi * c * c;

        double areaTrapezio = ((c + a) * c) / 2.0;

        double areaQuadrado = b * b;

        double areaRetangulo = a * b;

        System.out.printf("TRIANGULO: %.3f%n", areaTriangulo);
        System.out.printf("CIRCULO: %.3f%n", areaCirculo);
        System.out.printf("TRAPEZIO: %.3f%n", areaTrapezio);
        System.out.printf("QUADRADO: %.3f%n", areaQuadrado);
        System.out.printf("RETANGULO: %.3f%n", areaRetangulo);

        scan.close();
    }
}
