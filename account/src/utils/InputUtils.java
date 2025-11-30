/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author jorge-victor
 */
public class InputUtils {

    public int readInt(Scanner scan, String msg) {
        try {
            return Integer.parseInt(scan.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Deve digitar um numero inteiro Valido!");
        }
        return 1;
    }
}
