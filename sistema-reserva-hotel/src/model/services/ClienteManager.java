/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.services;

import java.util.ArrayList;
import model.entities.Cliente;

/**
 *
 * @author jorge-victor
 */
public class ClienteManager {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void addCliente(Cliente c) {
        clientes.add(c);
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    public void pesquisarCliente(String nome) {
        ArrayList<Cliente> encontrados = new ArrayList<>();

        for (Cliente c : clientes) {
            if (c.getNomeCompleto().toLowerCase().contains(nome.toLowerCase())) {
                encontrados.add(c);
            }
        }

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum cliente encontrado!");
        }

        for (Cliente c : encontrados) {
            System.out.println(c);
        }
    }

    public Cliente consultarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        System.out.println("Cliente nao encontrado!");
        return null;
    }

    // Atualizar cliente
    public void atualizarCliente(int id, String nome, int telefone, String email, String documento) {
        Cliente c = consultarCliente(id);
        if (c != null) {
            c.setNomeCompleto(nome);
            c.setTelefone(telefone);
            c.setEmail(email);
            c.setDocumento(documento);
            System.out.println("Cliente atualizado com sucesso!");
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
