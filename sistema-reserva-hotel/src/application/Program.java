/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import model.entities.Cliente;
import model.entities.Payment;
import model.entities.Quarto;
import model.enums.Estado;
import model.enums.EstadoPagamento;
import model.enums.Metodo;
import model.enums.Tipo;
import model.services.ClienteManager;
import model.services.QuartoManager;
import model.services.ReservaManager;

/**
 *
 * @author jorge-victor
 */
public class Program {

    private static Scanner scan = new Scanner(System.in);
    private static ClienteManager clienteManager = new ClienteManager();
    private static QuartoManager quartoManager = new QuartoManager();
    private static ReservaManager reservaManager = new ReservaManager();

    public static void main(String[] args) {

        menuPrincipal();

    }

    private static void menuPrincipal() {
        int opcao;
        do {
            System.out.println("===== SISTEMA DE HOTEL =====");
            System.out.println("1. Gestao de Reservas");
            System.out.println("2. Gestao de Clientes");
            System.out.println("3. Gestao de Quartos");
            System.out.println("4. Pagamentos");
            System.out.println("5. Servicos Adicionais");
            System.out.println("6. Check-in");
            System.out.println("7. Check-out");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
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
                    System.out.print("");
                case 6 ->
                    realizarCheckIn();
                case 7 ->
                    realizarCheckOut();
                case 0 ->
                    System.out.println("Saindo do sistema...");
                default ->
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);
    }

    private static void menuGestaoClientes() {
        int opcao;
        do {
            System.out.println("===== GESTAO DE CLIENTES =====");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Pesquisar Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {

                case 1 ->

                    clienteManager.listarClientes();

                case 2 -> {

                    System.out.println("Nome do cliente: ");
                    String nome = scan.nextLine();
                    clienteManager.pesquisarCliente(nome);
                }
                case 0 ->
                    System.out.println("Voltando!!");
                default ->
                    System.out.println("Opcaoo invalida!");
            }
        } while (opcao != 0);
    }

    private static void menuGestaoQuartos() {
        int opcao;
        do {
            System.out.println("===== GESTAO DE QUARTOS =====");
            System.out.println("1. Criar Quarto");
            System.out.println("2. Alterar Estado");
            System.out.println("3. Listar Quartos");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Numero do quarto: ");
                    int numero = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Preco diario base: ");
                    double preco = scan.nextDouble();
                    scan.nextLine();

                    System.out.print("Tipo do quarto (STANDARD, DELUXE, SUITE): ");
                    Tipo tipo = Tipo.valueOf(scan.nextLine().toUpperCase());

                    System.out.print("Capacidade do quarto: ");
                    int capacidade = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Estado do quarto (ATIVO, MANUTENCAO, INATIVO): ");
                    Estado estado = Estado.valueOf(scan.nextLine().toUpperCase());

                    quartoManager.criarQuarto(new Quarto(numero, preco, tipo, capacidade, estado));
                }
                case 2 -> {
                    System.out.print("Digite o numero do quarto: ");
                    int numero = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Novo estado do quarto (ATIVO, MANUTENCAO, INATIVO): ");
                    Estado novoEstado = Estado.valueOf(scan.nextLine().toUpperCase());
                    quartoManager.alterarEstado(numero, novoEstado);

                    System.out.println("Estado atualizado com sucesso!");

                }
                case 3 -> {
                    quartoManager.listarQuartos();
                }
                case 0 ->
                    System.out.println("Voltando...");
                default ->
                    System.out.println("Opcao invalida!");
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
                case 1 -> {
                    System.out.print("Nome completo: ");
                    String nome = scan.nextLine();

                    System.out.print("Telefone: ");
                    int telefone = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Email: ");
                    String email = scan.nextLine();

                    System.out.print("Documento (BI/Passaporte): ");
                    String doc = scan.nextLine();

                    Cliente client = new Cliente(telefone, email, nome, doc);

                    clienteManager.addCliente(client);

                    quartoManager.listarQuartos();

                    System.out.print("Digite o número do quarto: ");
                    int numeroQuarto = scan.nextInt();
                    scan.nextLine();

                    Quarto quarto = quartoManager.buscarQuarto(numeroQuarto);

                    System.out.print("Quantidade de hospedes: ");
                    int qtde = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Data de check-in (AAAA-MM-DD): ");
                    LocalDate checkIn = LocalDate.parse(scan.nextLine());

                    System.out.print("Data de check-out (AAAA-MM-DD): ");
                    LocalDate checkOut = LocalDate.parse(scan.nextLine());

                    reservaManager.criarReserva(qtde, checkIn, checkOut, client, quarto);

                }
                case 2 ->
                    reservaManager.ImprimirReservas();
                case 3 -> {

                    System.out.print("Codigo da reserva: ");
                    int id = scan.nextInt();
                    scan.nextLine();

                    reservaManager.cancelarReserva(id);
                }
                case 4 -> {
                    System.out.print("Codigo da reserva: ");
                    int id = scan.nextInt();
                    scan.nextLine();

                    System.out.print("NovaData de check-in (AAAA-MM-DD): ");
                    LocalDate checkIn = LocalDate.parse(scan.nextLine());

                    System.out.print("NovaData de check-out (AAAA-MM-DD): ");
                    LocalDate checkOut = LocalDate.parse(scan.nextLine());

                    reservaManager.actualizarReserva(id, checkIn, checkOut);
                }
                case 5 -> {
                    System.out.print("Codigo da reserva: ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    reservaManager.confirmarReserva(opcao);
                }

                case 0 ->
                    System.out.println("Voltando...");
                default ->
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    private static void realizarCheckIn() {
        System.out.println("Realizar Check-in...");
    }

    private static void realizarCheckOut() {
        System.out.println("Realizar Check-out...");
    }
}
