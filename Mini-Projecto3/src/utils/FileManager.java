package utils;

import entities.Camiao;
import entities.Pacote;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helena Panzo
 */
public class FileManager {

    public static ArrayList<Pacote> readFile(Camiao camiao) {

        ArrayList<Pacote> pacotes = new ArrayList<>();

        String fileName = "delivery_data.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }

                if (camiao.getCapacidade() == 0) {

                    int capacidade = Integer.parseInt(line.trim());

                    try {
                        camiao.setCapacidade(capacidade);
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                String[] partes = line.trim().split(" ");

                if (partes.length != 2) {
                    continue;
                }

                int peso = Integer.parseInt(partes[0].trim());
                double valor = Double.parseDouble(partes[1].trim());

                pacotes.add(new Pacote(peso, valor));
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return pacotes;
    }

    public static void writeFile(List<Pacote> pacotes, Camiao camiao) {

        String fileName = "solucao_pacotes.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            bw.write("# CAPACIDADE DO CAMIÃO (kg)\n");
            bw.write(camiao.getCapacidade() + "\n");
            

            bw.write("# PESO (kg) |  VALOR ECONOMICO");
            for (Pacote p : pacotes) {
                bw.newLine();
                bw.write(p.getPeso() + " " + p.getValor());
            }

            System.out.println("Solucao salva: " + fileName);

        } catch (IOException e) {
            System.out.println("Erro ao escrever ficheiro: " + e.getMessage());
        }
    }
}
