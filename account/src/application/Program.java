/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import db.DB;
import java.util.Scanner;
import model.entities.Account;
import model.exceptions.BusinessException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement ps = null;

        int opcao = -1;
        do {
            menu();
            opcao = scan.nextInt();
            scan.nextLine();
            try {
                switch (opcao) {

                    case 1 -> {

                        conn = DB.getConnection();

                        ps = conn.prepareStatement("INSERT "
                                + "INTO Account(Holder, Balance, WithDrawLimit) "
                                + "VALUES"
                                + " (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

                        System.out.println("ENTER ACCOUNT DATA");

                        System.out.print("Holder: ");
                        String holder = scan.nextLine();

                        System.out.print("Inicial Balance: ");
                        Double inicialBalance = scan.nextDouble();

                        System.out.print("Withdraw limit: ");
                        Double withdrawLimit = scan.nextDouble();

                        Account account = new Account(null, holder, inicialBalance, withdrawLimit);
                        ps.setString(1, account.getHolder());
                        ps.setDouble(2, account.getBalance());
                        ps.setDouble(3, account.getWithdrawLimit());

                        int rowAffected = ps.executeUpdate();
                        if (rowAffected > 0) {
                            ResultSet rs = ps.getGeneratedKeys();

                            while (rs.next()) {
                                int id = rs.getInt(1);
                                System.out.println("Account number " + id + " created");
                                account.setNumber(id);
                            }
                        }
                    }

                    case 2 -> {
                        conn = DB.getConnection();
                        ps = conn.prepareStatement("SELECT * FROM Account WHERE Id = ?");
                        PreparedStatement ps1 = conn.prepareStatement("UPDATE Account SET Balance = ? WHERE Id = ?");

                        System.out.println("Client Number: ");
                        int id = scan.nextInt();

                        ps.setInt(1, id);

                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {

                            Account account = new Account(rs.getInt("id"), rs.getString("Holder"), rs.getDouble("Balance"), rs.getDouble("WithDrawLimit"));
                            account.toString();

                            System.out.print("ENTER AMOUNT FOR DEPOSIT: ");
                            double amount = scan.nextDouble();

                            account.deposit(amount);

                            ps1.setDouble(1, account.getBalance());
                            ps1.setInt(2, id);

                            int rowsAffected = ps1.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("DONE!!");
                            }

                        } else {
                            System.out.println("Clinete nao encontrado!!");
                        }
                    }

                    case 3 -> {

                        conn = DB.getConnection();
                        ps = conn.prepareStatement("SELECT * FROM Account WHERE Id = ?");

                        System.out.print("Client Number: ");
                        int id = scan.nextInt();

                        ps.setInt(1, id);

                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            System.out.println("Cliente nao encontrado.");
                        } else {
                            while (rs.next()) {
                                System.out.println("Cliente name: " + rs.getString("Holder") + "Balance: " + rs.getString("Balance"));
                            }
                        }
                    }

                    case 4 -> {
                        conn = DB.getConnection();
                        ps = conn.prepareStatement("SELECT * FROM Account WHERE Id = ?");
                        PreparedStatement ps1 = conn.prepareStatement("DELETE from Account WHERE Id = ?", Statement.RETURN_GENERATED_KEYS);

                        System.out.print("Client Number: ");
                        int id = scan.nextInt();

                        ps.setInt(1, id);

                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            System.out.println("Cliente nao encontrado.");
                        } else {
                            ps1.setInt(1, id);
                            int rowsAffeted = ps1.executeUpdate();
                            if (rowsAffeted > 0) {
                                ResultSet rs1 = ps1.getGeneratedKeys();
                                while (rs.next()) {
                                    System.out.println("Account " + rs.getInt(1) + " Deleted");
                                }
                            }

                        }
                    }
                }
            } catch (BusinessException | SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private static void menu() {
        System.out.println("\n=== SISTEMA BANCARIO ===");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Fazer deposito");
        System.out.println("3 - Pesquisar cliente");
        System.out.println("4 - Apagar cliente");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");

    }

}
