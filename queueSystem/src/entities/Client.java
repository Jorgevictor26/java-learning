/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author jorge-victor
 */
public class Client {

    private static int idCounter = 1;

    private int clientId;
    private int numeroProdutos;

    public Client(int numeroProdutos) {
        this.clientId = idCounter++;
        this.numeroProdutos = numeroProdutos;
    }   

    public int getIdClient() {
        return clientId;
    }

    public int getNumeroProdutos() {
        return numeroProdutos;
    }
}
