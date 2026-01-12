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
        clientes.forEach(System.out::println);
    }

    public Cliente pesquisarCliente(String documento) {
        return clientes.stream()
                .filter(c -> c.getDocumento().equalsIgnoreCase(documento))
                .findFirst()
                .orElse(null);
    }

    // Atualizar cliente
    public void atualizarCliente(String nome, String telefone, String email, String documento) {
        Cliente c = pesquisarCliente(documento);
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
