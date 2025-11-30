/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IOpackage;

import entities.Produto;
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

    public ArrayList<Produto> readFile(String fileName) {

        ArrayList<Produto> produtos = new ArrayList();

        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                String partes[] = line.split(",");
                if (partes.length != 3) {
                    System.out.println("Linha Invalida : " + line);
                    continue;
                }

                String name = partes[0].trim();
                double precoUnitario = Double.parseDouble(partes[1].trim());
                int qtidade = Integer.parseInt(partes[2].trim());

                produtos.add(new Produto(name, precoUnitario, qtidade));
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return produtos;
    }

    public void writeFile(ArrayList<Produto> produtos, String fileName) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Produto p : produtos) {
                bw.write(p.getNomeProduto() + "," + String.format("%.2f", p.precoTotal()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
