/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;


import model.enums.FormaCobranca;
import model.enums.TipoServico;
import model.exceptions.CapacidadeException;

/**
 *
 * @author jorge-victor
 */
public class ServicoAdicional {

    private String descricao;
    private double precoUnitario;
    private int quantidade;

    private TipoServico tipoServico;
    private FormaCobranca formaCobranca;

    public ServicoAdicional() {
    }

    public ServicoAdicional(int quantidade, TipoServico tipoServico, FormaCobranca formaCobranca) {
        this.quantidade = quantidade;
        this.tipoServico = tipoServico;
        this.formaCobranca = formaCobranca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public FormaCobranca getFormaCobranca() {
        return formaCobranca;
    }

    public void setFormaCobranca(FormaCobranca formaCobranca) {
        this.formaCobranca = formaCobranca;
    }

    public double getTotalServico(long noites) {

        switch (this.formaCobranca) {
            case POR_NOITE -> {
                return precoUnitario * noites;
            }
            case FIXO -> {
                return precoUnitario;
            }
            case POR_UNIDADE -> {
                return precoUnitario * quantidade;
            }
            default -> {
                throw new CapacidadeException("Opcao invalida");
            }
        }
    }

}
