/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.DadosCorrida;

/**
 *
 * @author jorge-victor
 */
public class FileManager {

    private static final String ARQUIVO = "VariaveisDinamicas";

    public static DadosCorrida readData() {

        DadosCorrida dados = new DadosCorrida();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.contains(":")) {
                    continue;
                }

                String[] partes = line.split(":");

                if (partes.length != 2) {
                    continue;
                }

                String chave = partes[0].trim();
                String valor = partes[1].trim();

                switch (chave) {
                    case "PrecoBase" ->
                        dados.setPrecoBase(Integer.parseInt(valor));
                    case "PrecoPorKm" ->
                        dados.setPrecoPorKm(Integer.parseInt(valor));
                    case "Oferta" ->
                        dados.setOferta(Integer.parseInt(valor));
                    case "Demanda" ->
                        dados.setDemanda(Integer.parseInt(valor));
                    case "Hora" ->
                        dados.setHora(Integer.parseInt(valor));
                    case "Clima" ->
                        dados.setClima(Boolean.parseBoolean(valor));
                    case "Evento" ->
                        dados.setEvento(Boolean.parseBoolean(valor));
                    case "Distancia" ->
                        dados.setDistancia(Integer.parseInt(valor));
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return dados;
    }
}
