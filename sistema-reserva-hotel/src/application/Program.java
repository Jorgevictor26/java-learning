/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.util.Scanner;

/**
 *
 * @author jorge-victor
 */
public class Program {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        menuPrincipal();

    }

    private static void menuPrincipal() {
        int opcao;
        do {
            System.out.println("===== SISTEMA DE HOTEL =====");
            System.out.println("1. Gestão de Reservas");
            System.out.println("2. Gestão de Clientes");
            System.out.println("3. Gestão de Quartos");
            System.out.println("4. Pagamentos");
            System.out.println("5. Serviços Adicionais");
            System.out.println("6. Check-in");
            System.out.println("7. Check-out");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1 ->
                    menuGestaoReservas();
                case 2 ->
                    menuGestaoClientes();
                case 3 ->
                    menuGestaoQuartos();
                case 4 ->
                    menuPagamentos();
                case 5 ->
                    menuServicosAdicionais();
                case 6 ->
                    realizarCheckIn();
                case 7 ->
                    realizarCheckOut();
                case 0 ->
                    System.out.println("Saindo do sistema...");
                default ->
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private static void menuGestaoClientes() {
        int opcao;
        do {
            System.out.println("===== GESTAO DE CLIENTES =====");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Consultar Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1 ->
                    System.out.println("Criar Cliente...");
                case 2 ->
                    System.out.println("Listar Clientes...");
                case 3 ->
                    System.out.println("Actualizar Cliente...");
                case 4 ->
                    System.out.println("Consultar Cliente...");
                case 0 ->
                    System.out.println("Voltando...");
                default ->
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuGestaoQuartos() {
        int opcao;
        do {
            System.out.println("===== GESTÃO DE QUARTOS =====");
            System.out.println("1. Criar Quarto");
            System.out.println("2. Alterar Estado");
            System.out.println("3. Listar Quartos");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1 ->
                    System.out.println("Criar Quarto...");
                case 2 ->
                    System.out.println("Alterar Estado...");
                case 3 ->
                    System.out.println("Listar Quartos...");
                case 0 ->
                    System.out.println("Voltando...");
                default ->
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuGestaoReservas() {
        int opcao;
        do {
            System.out.println("===== GESTÃO DE RESERVAS =====");
            System.out.println("1. Criar Reserva");
            System.out.println("2. Listar Reservas");
            System.out.println("3. Cancelar Reserva");
            System.out.println("4. Actualizar Reserva");
            System.out.println("5. Confirmar Reserva");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1 ->
                    System.out.println("Criar Reserva...");
                case 2 ->
                    System.out.println("Listar Reservas...");
                case 3 ->
                    System.out.println("Cancelar Reserva...");
                case 4 ->
                    System.out.println("Actualizar Reserva...");
                case 5 ->
                    System.out.println("Confirmar Reserva...");
                case 0 ->
                    System.out.println("Voltando...");
                default ->
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuPagamentos() {
        int opcao;
        do {
            System.out.println("===== PAGAMENTOS =====");
            System.out.println("1. Registar Pagamento");
            System.out.println("2. Confirmar Pagamento");
            System.out.println("3. Ver Pagamento de Reserva");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1 ->
                    System.out.println("Registar Pagamento...");
                case 2 ->
                    System.out.println("Confirmar Pagamento...");
                case 3 ->
                    System.out.println("Ver Pagamento de Reserva...");
                case 0 ->
                    System.out.println("Voltando...");
                default ->
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void menuServicosAdicionais() {
        int opcao;
        do {
            System.out.println("===== SERVIÇOS ADICIONAIS =====");
            System.out.println("1. Adicionar Serviço a Reserva");
            System.out.println("2. Listar Serviços");
            System.out.println("3. Remover Serviço");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1 ->
                    System.out.println("Adicionar Serviço...");
                case 2 ->
                    System.out.println("Listar Serviços...");
                case 3 ->
                    System.out.println("Remover Serviço...");
                case 0 ->
                    System.out.println("Voltando...");
                default ->
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void realizarCheckIn() {
        System.out.println("Realizar Check-in...");
    }

    private static void realizarCheckOut() {
        System.out.println("Realizar Check-out...");
    }

    System.out.println (
            

    "===DADOS CLIENTE===");
    System.out.print (
            
    "Nome completo: ");
        String nome = scan.nextLine();

    System.out.print (
            
    "Telefone: ");
        int telefone = scan.nextInt();

    scan.nextLine (); // limpar buffer

    System.out.print (
            
    "Email: ");
        String email = scan.nextLine();

    System.out.print (
            
    "Dsocumento (BI/Passaporte): ");
        String documento = scan.nextLine();

}
}
