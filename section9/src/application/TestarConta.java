/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

/**
 *
 * @author jorge-victor
 */
import java.util.Scanner;
import entities.Conta;

public class TestarConta {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Conta conta;

        System.out.print("Numero da conta: ");
        int numeroDaConta = scan.nextInt();

        System.out.print("Titular da conta: ");
        scan.nextLine();
        String nome = scan.nextLine();

        System.out.print("Deseja fazer um deposito inicial?(y/n");
        char resp = scan.next().charAt(0);

        if (resp == 'y' || resp == 'Y') {

            System.out.print("Quantidade do deposito: ");
            double amount = scan.nextDouble();

            conta = new Conta(nome, amount, numeroDaConta);
        } else {
            conta = new Conta(nome, numeroDaConta);
        }

        System.out.println("Dados da conta: ");
        System.out.println(conta);

        scan.close();
    }
}
