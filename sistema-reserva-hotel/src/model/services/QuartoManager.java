/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

import java.util.ArrayList;
import model.entities.Quarto;
import model.enums.Estado;

/**
 *
 * @author jorge-victor
 */
public class QuartoManager {

    private ArrayList<Quarto> quartos = new ArrayList<>();

    public void criarQuarto(Quarto q) {
        quartos.add(q);
        System.out.println("Quarto criado: " + q.getNumero());
    }

    public Quarto buscarQuarto(int numeroQrt) {

        return quartos.stream()
                .filter(q -> q.getNumero() == numeroQrt)
                .findFirst().orElse(null);
    }

    public void listarQuartos() {
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado.");
            return;
        }
        quartos.forEach(System.out::println);
    }

    public void alterarEstado(int numeroQrt, Estado novoEstado) {
        Quarto quarto = buscarQuarto(numeroQrt);
        if (quarto != null) {
            quarto.setEstado(novoEstado);
        } else {
            System.out.println("Quarto nao encontrado!!");
        }
    }

    public ArrayList<Quarto> getQuartos() {
        return quartos;
    }
}
