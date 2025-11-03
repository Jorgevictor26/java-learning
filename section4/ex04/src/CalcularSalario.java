/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
 Fazer um programa que leia o número de um funcionário, seu número de horas trabalhadas, o valor que recebe por
hora e calcula o salário desse funcionário. A seguir, mostre o número e o salário do funcionário, com duas casas
decimais.
 */
import java.util.Scanner;

public class CalcularSalario {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite o seu numero: ");
        int numero = scan.nextInt();

        System.out.print("Digite o numero de horas trabalhadas: ");
        int horasTrabalhadas = scan.nextInt();

        System.out.print("Quanto recebes por hora: ");
        double valorPorHora = scan.nextDouble();
        
        double salario = horasTrabalhadas * valorPorHora;
        
        System.out.printf("Numero: %d\nSalario: %.2fkz\n", numero, salario);
    }
}
