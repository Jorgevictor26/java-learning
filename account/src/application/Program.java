/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.util.Scanner;
import model.entities.Account;
import model.dao.AccountDao;
import model.dao.DaoFactory;
import model.exceptions.BusinessException;
import model.exceptions.DbException;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        AccountDao accountDao = DaoFactory.createAccountDao();

        int opcao = -1;
        do {
            try {

                menu();
                opcao = scan.nextInt();
                scan.nextLine();
                switch (opcao) {

                    case 1 -> {

                        System.out.println("ENTER ACCOUNT DATA");

                        System.out.print("Holder: ");
                        String holder = scan.nextLine();

                        System.out.print("Inicial Balance: ");
                        Double inicialBalance = scan.nextDouble();

                        System.out.print("Withdraw limit: ");
                        Double withdrawLimit = scan.nextDouble();

                        Account account = new Account(null, holder, inicialBalance, withdrawLimit);

                        accountDao.insert(account);

                        System.out.println("Account Number " + account.getNumber() + " created");

                    }

                    case 2 -> {
                        System.out.println("Client Account Number: ");
                        int accountNumber = scan.nextInt();
                        scan.nextLine();
                        
                        Account account = accountDao.findById(accountNumber);

                        
                        if (account == null) {
                            System.out.println("Conta nao encontrada");
                        } else {
                            System.out.println("Amount: ");
                            double amount = scan.nextDouble();

                            account.deposit(amount);

                            accountDao.deposit(account.getNumber(), amount);
                            System.out.println("Donee!!");
                        }
                    }

                    case 3 -> {

                        System.out.print("Client Number: ");
                        int accountNumber = scan.nextInt();
                        scan.nextLine();

                        Account account = accountDao.findById(accountNumber);

                        if (account == null) {
                            System.out.println("Conta nao encontrada");
                        } else {
                            System.out.println(account);
                        }

                    }

                    case 4 -> {

                        System.out.print("Client Number: ");
                        int accountNumber = scan.nextInt();
                        scan.nextLine();

                        accountDao.delete(accountNumber);

                        System.out.println("Account deleted successfully!");
                    }

                    case 5 -> {

                        System.out.print("Client Number: ");
                        int accountNumber = scan.nextInt();
                        scan.nextLine();

                        Account account = accountDao.findById(accountNumber);

                        if (account == null) {
                            System.out.println("Conta nao encontrada");
                        } else {
                            System.out.println("Amount: ");
                            double amount = scan.nextDouble();

                            account.withdraw(amount);

                            accountDao.withDraw(account.getNumber(), amount);
                        }
                    }

                    case 6 -> {

                        System.out.print("Client Number: ");
                        int accountNumber = scan.nextInt();
                        scan.nextLine();

                        Account account = accountDao.findById(accountNumber);

                        if (account == null) {
                            System.out.println("Conta nao encontrada");
                        } else {
                            System.out.println("New Name: ");
                            String holder = scan.nextLine();

                            account.setHolder(holder);

                            accountDao.updateName(account);
                            System.out.println("Account Updated");
                        }
                    }
                }
            } catch (DbException | BusinessException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private static void menu() {
        System.out.println("\n=== BANK SYSTEM ===");
        System.out.println("1 - Create Account");
        System.out.println("2 - Deposit");
        System.out.println("3 - Search client");
        System.out.println("4 - Deleted account");
        System.out.println("5 - WithDraw");
        System.out.println("6 - Update Account");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");

    }
}
