/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modes;

import java.util.Random;

public class AutomaticMode extends ManualMode {

    private final int INTERVALO_MAXIMO_PADRAO = 15;
    private int intervaloMaximoEntreClientes;

    public AutomaticMode() {
        super(); // chama o construtor do ManualMode
    }

    @Override
    public void iniciarSimulacao() {

        System.out.println("=== Simulacao Automatica do Supermercado ===");

        System.out.print("Informe o tempo de atendimento por produto (ENTER para " + TEMPO_DE_ATENDIMENTO_PADRAO + "s): ");
        String tempoInput = scan.nextLine().trim();

        tempoPorProduto = tempoInput.isEmpty() ? TEMPO_DE_ATENDIMENTO_PADRAO : Integer.parseInt(tempoInput);

        System.out.print("Informe o numero de caixas (ENTER para " + NUMERO_DE_CAIXAS_PADRAO + "): ");
        String caixasInput = scan.nextLine().trim();

        int numCaixas = caixasInput.isEmpty() ? NUMERO_DE_CAIXAS_PADRAO : Integer.parseInt(caixasInput);

        // Pergunta intervalo máximo entre clientes
        System.out.print("Informe o intervalo maximo entre clientes (ENTER para " + INTERVALO_MAXIMO_PADRAO + "s): ");
        String intervaloInput = scan.nextLine().trim();

        intervaloMaximoEntreClientes = intervaloInput.isEmpty() ? INTERVALO_MAXIMO_PADRAO : Integer.parseInt(intervaloInput);

        // Cria caixas
        for (int i = 0; i < numCaixas; i++) {
            adicionarCaixa();
        }

        System.out.println("\nSimulacao automatica iniciada!!");

        // Executa sequencia automatica
        boolean continuar = true;
        
        while (continuar) {

            mostrarFilas(); 

            // Gera tempo aleatorio entre 1 e intervalo máximo
            int tempoAleatorio = 1 + new Random().nextInt(intervaloMaximoEntreClientes);

            criarCliente(); // cria cliente e adiciona na menor fila

            atenderTempo(tempoAleatorio); // atende X segundos

            System.out.println("ENTER para continuar e  'fim' para encerrar... ");
            String entrada = scan.nextLine();

            if (entrada.equalsIgnoreCase("fim")) {
                continuar = false;
            }
        }

        System.out.println("Simulacao automatica encerrada!");
    }
}
