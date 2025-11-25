/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inputOutput;

import entities.Caixa;
import entities.Client;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jorge-victor
 */
public class FileManager {

    public void writeFile(String fileName, ArrayList<Caixa> caixas) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            for (Caixa c : caixas) {

                // s
                bw.write("Caixa: " + c.getIdCaixa());
                bw.newLine();

                // 
                bw.write("clientQueue: " + c.getFila().size() + ", "
                        + "clientesAtendidos: " + c.getClientesAtendidos() + ", "
                        + "tempoTotalAtendimento: " + c.getTempoTotalAtendimento() + ", "
                        + "tempoMedioAtendimento: " + String.format("%.1f", c.getTempoMedioAtendimento()) + ", "
                        + "tempoRestante: " + c.getTempoRestante());
                bw.newLine();

                //  Lista de clientes
                for (Client client : c.getFila()) {
                    bw.write("IdClient: " + client.getIdClient() + ", Produtos: " + client.getNumeroProdutos());
                    bw.newLine();
                }

                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
