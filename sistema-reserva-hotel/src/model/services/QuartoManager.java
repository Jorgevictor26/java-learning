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
        Quarto quarto = null;
        for (Quarto q : quartos) {
            if (q.getNumero() == numeroQrt) {
                quarto = q;
                break;
            }
        }
        return quarto;
    }

    public void listarQuartos() {
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado.");
            return;
        }
        for (Quarto q : quartos) {
            System.out.println(q);
        }
    }

    public void alterarEstado(int numeroQrt, Estado novoEstado) {
        for (Quarto q : quartos) {
            if (q.getNumero() == numeroQrt) {
                q.setEstado(novoEstado);
                System.out.println("Estado do quarto alterado para: " + novoEstado);
                return;
            }
        }
        System.out.println("Quarto nao encontrado!");
    }

    public ArrayList<Quarto> getQuartos() {
        return quartos;
    }
}
