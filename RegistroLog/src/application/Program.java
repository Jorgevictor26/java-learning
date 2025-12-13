/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import entities.Log;
import java.util.Set;
import utils.FileManager;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {
        Set<Log> logs = FileManager.readFile();
        System.out.println("Total users: " + logs.size());
    }
}
