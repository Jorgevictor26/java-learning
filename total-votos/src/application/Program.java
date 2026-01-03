/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {

        Map<String, Integer> votes = new HashMap();

        try (BufferedReader br = new BufferedReader(new FileReader("registros.csv"))) {

            String line;
            while ((line = br.readLine()) != null) {

                String parts[] = line.split(",");

                String name = parts[0];
                int qtidadeVotos = Integer.parseInt(parts[1]);

                if (votes.containsKey(name)) {
                    int votos = votes.get(name);
                    votes.put(name, votos + qtidadeVotos);
                } else {
                    votes.put(name, qtidadeVotos);
                }
            }

            for (String key : votes.keySet()) {
                System.out.println(key + ": " + votes.get(key));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
