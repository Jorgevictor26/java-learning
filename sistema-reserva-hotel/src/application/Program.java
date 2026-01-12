/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.entities.Cliente;
import model.entities.Payment;
import model.entities.Quarto;
import model.entities.Reserva;
import model.entities.ServicoAdicional;
import model.enums.Estado;
import model.enums.FormaCobranca;
import model.enums.Metodo;
import model.enums.Tipo;
import model.enums.TipoServico;
import model.exceptions.BussinessException;
import model.services.ClienteManager;
import model.services.QuartoManager;
import model.services.ReservaManager;
import utils.DataValidator;

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
        int opcao = -1;
        do {
            try {
                System.out.println("===== SISTEMA DE HOTEL =====");
                System.out.println("1. Gestao de Reservas");
                System.out.println("2. Gestao de Clientes");
                System.out.println("3. Gestao de Quartos");
                System.out.println("4. Pagamentos");
                System.out.println("5. Adicionar Servico");
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
                        Pagamento();
                    case 5 ->
                        adicionarServico();
                    case 6 ->
                        CheckIn();
                    case 7 ->
                        CheckOut();
                    case 0 ->
                        System.out.println("Saindo do sistema...");
                    default ->
                        System.out.println("Opcao invalida!");
                }

            } catch (BussinessException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());

                scan.nextLine();
                opcao = -1;
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

                    System.out.println("Documento: ");
                    String nome = scan.nextLine();
                    Cliente cliente = clienteManager.pesquisarCliente(nome);
                    if (cliente == null) {
                        System.out.println("Cliente nao encontrado");
                    } else {
                        System.out.println(cliente);
                    }
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
                    System.out.println("===CADASTRAR QUARTO===");

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

                    quartoManager.criarQuarto(new Quarto(preco, tipo, capacidade, estado));
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
            System.out.println("===== GESTAO DE RESERVAS =====");
            System.out.println("1. Criar Reserva");
            System.out.println("2. Listar Reservas");
            System.out.println("3. Cancelar Reserva");
            System.out.println("4. Actualizar Reserva");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opcao: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1 -> {
                    Reserva reserva = null;
                    Cliente cliente = null;

                    System.out.print("O cliente ja tem cadastro? (S/N): ");
                    String cadastrado = scan.nextLine();

                    if (cadastrado.equalsIgnoreCase("S")) {
                        System.out.print("BI: ");
                        String bi = scan.nextLine();

                        cliente = clienteManager.pesquisarCliente(bi);

                        if (cliente == null) {
                            System.out.println("❌Cliente nao encontrado.");
                            return;
                        }

                    } else {
                        System.out.print("Nome completo: ");
                        String nome = scan.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = scan.nextLine();

                        System.out.print("Email: ");
                        String email = scan.nextLine();

                        System.out.print("Documento (BI): ");
                        String doc = scan.nextLine();

                        if (!DataValidator.validarEmail(email)) {
                            System.out.println("Email invalido!");
                        } else if (!DataValidator.validarBI(doc)) {
                            System.out.println("BI invalido!");
                        } else if (!DataValidator.validarTelefone(telefone)) {
                            System.out.println("Telefone invalido!");
                        } else {
                            cliente = new Cliente(telefone, email, nome, doc);

                            clienteManager.addCliente(cliente);
                            System.out.println("Cliente cadastrado.");
                        }

                    }
                    ArrayList<Quarto> quartos = quartoManager.getQuartos();

                    if (quartos.isEmpty()) {
                        System.out.println("Nao tem quarto cadastrado!");
                    } else {
                        quartoManager.listarQuartos();

                        System.out.print("Digite o numero do quarto: ");
                        int numeroQuarto = scan.nextInt();
                        scan.nextLine();

                        Quarto quarto = quartoManager.buscarQuarto(numeroQuarto);

                        if (quarto != null) {

                            System.out.print("Quantidade de hospedes: ");
                            int qtde = scan.nextInt();
                            scan.nextLine();

                            System.out.print("Data de check-in (AAAA-MM-DD): ");
                            LocalDate checkIn = LocalDate.parse(scan.nextLine());

                            System.out.print("Data de check-out (AAAA-MM-DD): ");
                            LocalDate checkOut = LocalDate.parse(scan.nextLine());

                            reserva = reservaManager.criarReserva(qtde, checkIn, checkOut, cliente, quarto);
                        } else {
                            System.out.println("Quarto nao encontrado!!");
                        }

                        System.out.println("Valor total a pagar: " + reserva.getTotalReserva());

                        System.out.print("Pagar? (S/N): ");
                        String resp = scan.nextLine();

                        if (resp.equalsIgnoreCase("S")) {

                            System.out.print("Valor do pagamento: ");
                            double valor = scan.nextDouble();
                            scan.nextLine();

                            System.out.print("Metodo de pagamento (DINHEIRO, TPA, TRANSFERENCIA): ");
                            Metodo metodo = Metodo.valueOf(scan.nextLine().toUpperCase());
                            reserva.registarPagamento(valor, metodo);

                        } else {
                            System.out.println("Reserva criada. Pagamento pendente.");
                        }
                    }
                }

                case 2 ->
                    reservaManager.ListarReservas();
                case 3 -> {

                    System.out.print("Codigo da reserva: ");
                    int id = scan.nextInt();
                    scan.nextLine();

                    reservaManager.cancelarReserva(id);
                }
                case 4 -> {
                    System.out.print("Codigo da reserva: ");
                    int codigo = scan.nextInt();
                    scan.nextLine();
                    Reserva reserva = reservaManager.buscarReserva(codigo);
                    if (reserva != null) {
                        System.out.print("NovaData de check-in (AAAA-MM-DD): ");
                        LocalDate checkIn = LocalDate.parse(scan.nextLine());

                        System.out.print("NovaData de check-out (AAAA-MM-DD): ");
                        LocalDate checkOut = LocalDate.parse(scan.nextLine());

                        reservaManager.actualizarReserva(reserva, checkIn, checkOut);
                    } else {
                        System.out.println("Reserva nao existe!!");
                    }

                }
                case 0 ->
                    System.out.println("Voltando...");
                default ->
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);
    }

    private static void Pagamento() {

        int op;
        do {
            System.out.println("\n===== PAGAMENTOS =====");
            System.out.println("1 - Registar pagamento");
            System.out.println("2 - Ver pagamentos de uma reserva");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            op = scan.nextInt();
            scan.nextLine();

            switch (op) {

                case 1 -> {
                    System.out.print("Codigo da reserva: ");
                    int codigo = scan.nextInt();
                    scan.nextLine();

                    Reserva reserva = reservaManager.buscarReserva(codigo);

                    if (reserva == null) {
                        System.out.println("Reserva nao encontrada.");
                        break;
                    }

                    System.out.println("Total da hospedagem: " + reserva.getValorHospedagem());
                    System.out.println("Total ja pago: " + reserva.getTotalPago());

                    System.out.print("Valor a pagar: ");
                    double valor = scan.nextDouble();
                    scan.nextLine();

                    System.out.println("Metodo:");
                    System.out.println("1 - DINHEIRO");
                    System.out.println("2 - CARTAO");
                    System.out.println("3 - TRANSFERENCIA");
                    System.out.print("Escolha: ");
                    int m = scan.nextInt();
                    scan.nextLine();

                    Metodo metodo = Metodo.values()[m - 1];
                    reserva.registarPagamento(valor, metodo);

                    if (reserva.isTotalmentePago(valor)) {
                        System.out.println("Reserva totalmente paga.");
                    } else {
                        System.out.println("Pagamento parcial registado.");
                    }
                }
                case 2 -> {
                    System.out.print("Codigo da reserva: ");
                    int codigo = scan.nextInt();
                    scan.nextLine();

                    Reserva reserva = reservaManager.buscarReserva(codigo);

                    if (reserva == null) {
                        System.out.println("Reserva nao encontrada.");
                        break;
                    }

                    if (reserva.getPagamentos().isEmpty()) {
                        System.out.println("Esta reserva nao tem pagamentos.");
                        break;
                    }

                    System.out.println("\nPagamentos da reserva " + codigo);
                    for (Payment p : reserva.getPagamentos()) {
                        System.out.println(p);
                    }

                    System.out.println("Total pago: " + reserva.getTotalPago());
                    System.out.println("Total da hospedagem: " + reserva.getValorHospedagem());
                }

                case 0 ->
                    System.out.println("Voltando...");
                default ->
                    System.out.println("Opcao invalida!");
            }

        } while (op != 0);
    }

    private static void adicionarServico() {
        System.out.println("Adicionar serviço a uma reserva");
        System.out.print("Código da reserva: ");
        int codigo = scan.nextInt();
        scan.nextLine();

        Reserva reserva = reservaManager.buscarReserva(codigo);

        if (reserva == null) {
            System.out.println("Reserva nao encontrada");
        } else {

            System.out.print("Preço unitario: ");
            double preco = scan.nextDouble();

            System.out.print("Quantidade: ");
            int qtd = scan.nextInt();
            scan.nextLine();

            TipoServico tipoServico = null;

            System.out.println("Escolha o Tipo de Serviço:");
            System.out.println("1 - PEQUENO_ALOMOCO");
            System.out.println("2 - LAVANDERIA");
            System.out.println("3 - TRANSPORTE");
            System.out.println(" 4 - OUTRO");
            System.out.print("Opcao: ");
            int opTipo = scan.nextInt();
            scan.nextLine();

            switch (opTipo) {
                case 1 ->
                    tipoServico = TipoServico.PEQUENO_ALMOCO;
                case 2 ->
                    tipoServico = TipoServico.LAVANDARIA;
                case 3 ->
                    tipoServico = TipoServico.TRANSPORTE;
                case 4 ->
                    tipoServico = TipoServico.OUTRO;
                default -> {
                    System.out.println("Opcao invalida, usando PEQUENO ALMOCO por padrao.");
                    tipoServico = TipoServico.PEQUENO_ALMOCO;
                }
            }

            FormaCobranca formaCobranca = null;
            System.out.println("Forma de Cobranca:");
            System.out.println("1 - POR_NOITE");
            System.out.println("2 - FIXO");
            System.out.println("3- POR_UNIDADE");
            System.out.print("Opcao: ");
            int opCobranca = scan.nextInt();
            scan.nextLine();

            switch (opCobranca) {
                case 1 ->
                    formaCobranca = FormaCobranca.POR_NOITE;
                case 2 ->
                    formaCobranca = FormaCobranca.FIXO;
                case 3 ->
                    formaCobranca = FormaCobranca.POR_UNIDADE;
                default -> {
                    System.out.println("Opcao invalida, usando POR_NOITEpor padrao.");
                    formaCobranca = FormaCobranca.POR_NOITE;
                }
            }

            ServicoAdicional s = new ServicoAdicional(preco, qtd, tipoServico, formaCobranca);
            reserva.addServico(s);
        }

    }

    private static void CheckIn() {

        System.out.print("Codigo da reserva: ");
        int codigo = scan.nextInt();
        scan.nextLine();

        reservaManager.processarCheckIn(codigo);

    }

    private static void CheckOut() {
        System.out.print("Codigo da reserva: ");
        int codigo = scan.nextInt();
        scan.nextLine();

        reservaManager.processarCheckOut(codigo);
    }
}
