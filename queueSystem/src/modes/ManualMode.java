/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modes;

import entities.Caixa;
import entities.Client;
import inputOutput.FileManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class ManualMode {

    // Configurações padrão do sistema
    protected final int NUMERO_DE_CAIXAS_PADRAO = 4;      // Numero inicial de caixas
    protected final int TEMPO_DE_ATENDIMENTO_PADRAO = 5;  // Tempo padrão por produto

    protected ArrayList<Caixa> caixas;
    protected double tempoPorProduto;

    protected Scanner scan = new Scanner(System.in);

    public ManualMode() {
        caixas = new ArrayList<>();
    }

    // Método principal que inicia a simulacao manual
    public void iniciarSimulacao() {

        System.out.print("Informe o tempo de atendimento por produto (ENTER para " + TEMPO_DE_ATENDIMENTO_PADRAO + "s): ");
        String tempo = scan.nextLine().trim();
        tempoPorProduto = tempo.isEmpty() ? TEMPO_DE_ATENDIMENTO_PADRAO : Integer.parseInt(tempo);

        System.out.print("Informe o numero de caixas (ENTER para " + NUMERO_DE_CAIXAS_PADRAO + "): ");
        String Qtdcaixas = scan.nextLine().trim();
        int numCaixas = Qtdcaixas.isEmpty() ? NUMERO_DE_CAIXAS_PADRAO : Integer.parseInt(Qtdcaixas);

        // Criar caixas iniciais
        for (int i = 0; i < numCaixas; i++) {
            adicionarCaixa();
        }

        int option = -1;

        while (option != 0) {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Mostrar filas das caixas");
            System.out.println("2 - Criar cliente");
            System.out.println("3 - Adicionar caixa");
            System.out.println("4 - Retirar caixa de Atendimento");
            System.out.println("5 - Atender T tempo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                option = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\n****DEVE DIGITAR UM NUMERO INTEIRO[0-5]****");
                option = -1;
            }

            switch (option) {
                case 1 ->
                    mostrarFilas();    // Mostra o estado atual das filas
                case 2 ->
                    criarCliente();
                case 3 ->
                    adicionarCaixa();  // Adiciona uma nova caixa vazia
                case 4 ->
                    retirarCaixaVazia(); // Remove caixas sem clientes
                case 5 -> {
                    try {
                        System.out.print("Informe o tempo T para atender (em segundos): ");
                        double T = Integer.parseInt(scan.nextLine());
                        atenderTempo(T);
                    } catch (NumberFormatException e) {
                        System.out.println("\n*****DEVE DIGITAR UM NUMERO *****");
                    }
                }
                case 0 ->
                    salvarAntesDeSair(); // Salva dados antes de sair
                default ->
                    System.out.println("OPCAO INVALIDA!");
            }
        }
    }

    // Exibe o estado das caixas e dos clientes em cada fila
    protected void mostrarFilas() {
        for (Caixa c : caixas) {
            System.out.printf("Caixa %d | Clientes na fila: %d | Tempo restante topo: %.1f | Clientes atendidos: %d | Tempo total: %.1f | Tempo médio: %.1f\n",
                    c.getIdCaixa(), c.getFila().size(), c.getTempoRestante(), c.getClientesAtendidos(),
                    c.getTempoTotalAtendimento(), c.getTempoMedioAtendimento());

            // Mostrar cliente
            for (Client client : c.getFila()) {
                System.out.printf("Cliente %03d (%d produtos) <- ", client.getIdClient(), client.getNumeroProdutos());
            }
            System.out.println();
        }
    }

    // Cria cliente com produtos aleatórios e adiciona na caixa com menor fila
    protected void criarCliente() {

        Random random = new Random();
        int produtos = 2 + random.nextInt(119); // gerar numeros aleatorios de 2 a 120 produtos
        Client client = new Client(produtos);

        // Procura caixa com menor fila
        Caixa caixaMenorFila = caixas.get(0);
        for (Caixa c : caixas) {
            if (c.numeroClientesFila() < caixaMenorFila.numeroClientesFila()) {
                caixaMenorFila = c;
            }
        }

        caixaMenorFila.addClient(client);

        // Se for o único cliente, atualiza tempoRestante
        if (caixaMenorFila.numeroClientesFila() == 1) {
            double tempoRestante = client.getNumeroProdutos() * tempoPorProduto;
            caixaMenorFila.setTempoRestante(tempoRestante);
        }

        System.out.println("Cliente " + String.format("%03d", client.getIdClient()) + " adicionado a Caixa " + caixaMenorFila.getIdCaixa());
    }

    // Adiciona uma nova caixa vazia ao sistema
    protected void adicionarCaixa() {
        Caixa caixa = new Caixa();
        caixas.add(caixa);
        System.out.printf("Caixa %d adicionada\n", caixa.getIdCaixa());
    }

    // Remove caixas sem clientes
    protected void retirarCaixaVazia() {

        Iterator<Caixa> it = caixas.iterator();

        boolean removed = false;

        while (it.hasNext()) {

            Caixa c = it.next();

            if (c.numeroClientesFila() == 0) {
                it.remove();
                System.out.println("Caixa " + c.getIdCaixa() + " removida");
                removed = true;
            }
        }
        if (!removed) {
            System.out.println("Sem caixas vazias para remover!!");
        }
    }

    // Atende clientes por um tempo T
    protected void atenderTempo(double T) {
        for (Caixa c : caixas) {
            while (T > 0 && c.numeroClientesFila() > 0) {
                double tempoRestante = c.getTempoRestante();

                if (T < tempoRestante) {
                    c.setTempoTotalAtendimento((int) (c.getTempoTotalAtendimento() + T));
                    c.setTempoRestante(tempoRestante - T);
                    T = 0; // todo o tempo usado
                } else {
                    c.atenderCliente(tempoRestante); // cliente atendido
                    T -= tempoRestante;

                    // Atualiza tempoRestante do próximo cliente
                    if (c.numeroClientesFila() > 0) {
                        Client nextClient = c.getFila().peek();
                        c.setTempoRestante(nextClient.getNumeroProdutos() * tempoPorProduto);
                    } else {
                        c.setTempoRestante(0);
                    }
                }
            }
        }
    }

    // Salva todos os dados antes de encerrar
    private void salvarAntesDeSair() {

        System.out.print("Nome do ficheiro para guardar: ");
        String file = scan.nextLine().trim();

        FileManager fm = new FileManager();

        fm.writeFile(file, caixas);

        System.out.println("Dados gravados no ficheiro: " + file);
        System.out.println("Simulacao terminada!");
    }

}
