/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex03;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jorge-victor
 */
public class TestarFuncionario {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

        System.out.print("Quantos trabalhadores vais registrar:");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.printf("\nTrabalhador#%d\n", i + 1);

            System.out.print("Id:");
            int id = scan.nextInt();

            scan.nextLine();

            System.out.print("Nome: ");
            String nome = scan.nextLine();

            System.out.print("Salario: ");
            double salario = scan.nextDouble();

            Funcionario funcionario = new Funcionario(nome, id, salario);
            
            listaFuncionarios.add(funcionario);
        }

        System.out.println("Deseja aumentar salario[y/n]?");
        char res = scan.next().charAt(0);

        if (res == 'y' || res == 'Y') {

            System.out.print("Id do funcionario para aumentar salario: ");
            int id = scan.nextInt();

            Integer posicao = calcularPosicao(listaFuncionarios, id);

            if (posicao != null) {

                System.out.print("Percentagem: ");
                double percent = scan.nextDouble();

                listaFuncionarios.get(posicao).aumentarSalario(percent);

            } else {
                System.out.println("ID nao existe!!");
            }
        }

        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println(funcionario);
        }

        scan.close();
    }

    static Integer calcularPosicao(ArrayList<Funcionario> listaFuncionarios, int id) {

        for (int i = 0; i < listaFuncionarios.size(); i++) {

            if (listaFuncionarios.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }
}
