/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex02;

/**
 *
 * @author jorge-victor
 */
import java.util.Scanner;

public class TestarPessoa {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Pessoa[] array;
        double somaAltura = 0.0;
        int countMenor16 = 0;

        System.out.println("Quantos Pessoas serao digitadas?");
        System.out.print("R: ");

        int tamArray = scan.nextInt();
        array = new Pessoa[tamArray];

        for (int i = 0; i < array.length; i++) {
            scan.nextLine();

            System.out.printf("Dados da %da pessoa: ", (i + 1));

            System.out.print("Nome: ");
            String nome = scan.nextLine();

            System.out.print("Idade :");
            int idade = scan.nextInt();

            System.out.print("Altura: ");
            double altura = scan.nextDouble();

            array[i] = new Pessoa(nome, idade, altura);

        }

        for (int i = 0; i < array.length; i++) {

            somaAltura += array[i].getAltura();
        }

        for (int i = 0; i < array.length; i++) {

            if (array[i].getIdade() < 16) {
                countMenor16++;
            }
        }

        double percentagemMenor16 = (countMenor16 / array.length) * 100;
        double mediaAltura = somaAltura / array.length;

        System.out.printf("Altura media %.2f%n", mediaAltura);
        System.out.printf("Pessoas com menos de 16 anos %.1f%%%n", percentagemMenor16);

        for (int i = 0; i < array.length; i++) {

            if (array[i].getIdade() < 16) {
                System.out.println(array[i].getNome());
            }
        }

        scan.close();
    }
}
