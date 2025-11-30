/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author jorge-victor
 */
public class Produto {

    private String nomeProduto;
    private double precoUnitario;
    private int qtidade;

    public Produto(String nomeProduto, double precoUnitario, int qtidade) {
        this.nomeProduto = nomeProduto;
        this.precoUnitario = precoUnitario;
        this.qtidade = qtidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(int precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQtidade() {
        return qtidade;
    }

    public double precoTotal() {
        return precoUnitario * qtidade;
    }
}
