/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author jorge-victor
 */
public class PessoaFisica extends Contribuinte {

    private double gastosSaude;

    public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double getImposto() {

        double taxaImposto;

        double imposto = 0.0;

        if (this.rendaAnual < 20000.00) {
            taxaImposto = 15;
        } else {
            taxaImposto = 25;
        }
        if (gastosSaude > 0) {
            // Retira-se 50% destes gastos no imposto
            imposto = (rendaAnual * (taxaImposto / 100)) - (gastosSaude * (50 / 100.0));
        }
        return imposto;
    }
}
