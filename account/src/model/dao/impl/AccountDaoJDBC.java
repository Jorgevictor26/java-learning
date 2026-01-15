/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.impl;

import java.sql.Statement;
import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.dao.AccountDao;
import model.entities.Account;
import model.exceptions.DbException;

/**
 *
 * @author jorge-victor
 */
public class AccountDaoJDBC implements AccountDao {

    private Connection conn = null;

    public AccountDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Account account) {

        PreparedStatement ps = null;

        try {

            ps = conn.prepareStatement("INSERT INTO Account(Holder, Balance, WithDrawLimit) VALUES(?,?,?) ", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, account.getHolder());
            ps.setDouble(2, account.getBalance());
            ps.setDouble(3, account.getWithdrawLimit());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    account.setNumber(rs.getInt(1));
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Unexpected Error!!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("DELETE FROM Account WHERE Id = ?");
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 0) {
                throw new DbException("Id Doesn't exist");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public void updateName(Account account) {
        PreparedStatement ps = null;

        try {

            ps = conn.prepareStatement("UPDATE Account SET Holder = ? "
                    + "WHERE Id = ?");

            ps.setString(1, account.getHolder());
            ps.setInt(2, account.getNumber());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public Account findById(Integer id) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM Account "
                    + "WHERE Id = ?");

            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                Account account = instantiateAccount(rs);
                return account;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public ArrayList<Account> findByName(String name) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM Account WHERE Holder = ?"
                    + "ORDER BY Holder");
            ps.setString(1, name);

            rs = ps.executeQuery();

            ArrayList<Account> accounts = new ArrayList<>();
            Map<Integer, Account> map = new HashMap();

            while (rs.next()) {

                Account account = map.get(rs.getInt("Id")); // verifica se ja existe

                if (account == null) {

                    account = instantiateAccount(rs);
                    map.put(rs.getInt("Id"), account);
                }

                accounts.add(account);

            }
            return accounts;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public ArrayList<Account> findAll() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Account> accounts = new ArrayList<>();

        try {
            ps = conn.prepareStatement("SELECT * FROM Account "
                    + "ORDER BY Holder");

            rs = ps.executeQuery();

            if (rs.next()) {
                Account account = instantiateAccount(rs);
                accounts.add(account);
            }
            return accounts;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public void deposit(Integer Id, Double amount) {
        PreparedStatement ps = null;

        try {

            ps = conn.prepareStatement("UPDATE Account SET Balance = Balance + ? "
                    + "WHERE Id = ?");

            ps.setDouble(1, amount);
            ps.setInt(2, Id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void withDraw(Integer Id, Double amount) {
        PreparedStatement ps = null;

        try {

            ps = conn.prepareStatement("UPDATE Account SET Balance = Balance - ? "
                    + "WHERE Id = ?");

            ps.setDouble(1, amount);
            ps.setInt(2, Id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    private Account instantiateAccount(ResultSet rs) throws SQLException {
        return new Account(rs.getInt("Id"), rs.getString("Holder"), rs.getDouble("Balance"), rs.getDouble("WithDrawLimit"));
    }
}
