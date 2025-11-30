/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import IOpackage.FileManager;
import entities.Produto;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        FileManager file = new FileManager();

        System.out.print("File name: ");
        String fileName = scan.nextLine();

        ArrayList<Produto> produtos = file.readFile(fileName);

        File parentfileName = new File(fileName);

        String parentFolder = parentfileName.getParent();

        boolean sucess = new File(parentFolder + "\\out").mkdir();

        String newFileName = parentFolder + "\\out\\summary.csv";

        file.writeFile(produtos, newFileName);

        for (Produto p : produtos) {
            System.out.println(p.getNomeProduto() + ", " + String.format("%.2f", p.total()));
        }
    }
}
