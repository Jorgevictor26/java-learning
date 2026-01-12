/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author jorge-victor
 */
public class DataValidator {

    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }

    public static boolean validarBI(String bi) {
        String regex = "^[0-9]{9}[A-Z]{2}[0-9]{3}$";
        return bi.matches(regex);
    }

    public static boolean validarTelefone(String telefone) {
        String regex = "^(91|92|93|94|95|96|97)[0-9]{7}$";
        return telefone.matches(regex);
    }
}
