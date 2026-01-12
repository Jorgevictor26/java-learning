/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

/**
 *
 * @author jorge-victor
 */
public class Cliente {

    private static int idCliente = 1;

    private int id;
    private String telefone;
    private String email;
    private String nomeCompleto;
    private String documento;

    public Cliente(String telefone, String email, String nomeCompleto, String documento) {
        this.id = idCliente++;
        this.telefone = telefone;
        this.email = email;
        this.nomeCompleto = nomeCompleto;
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", telefone=" + telefone + ", email=" + email + ", nomeCompleto=" + nomeCompleto + ", documento=" + documento + '}';
    }

}
