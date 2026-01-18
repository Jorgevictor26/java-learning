/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.impl;

import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dao.ClienteDao;
import model.entities.Cliente;
import model.exceptions.DbException;

/**
 *
 * @author jorge-victor
 */
public class ClienteDaoJDBC implements ClienteDao {

    private Connection conn;

    public ClienteDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Cliente cliente) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                    "INSERT INTO Cliente (BI, Nome, Email, Telefone) VALUES (?, ?, ?, ?)"
            );

            ps.setString(1, cliente.getDocumento());
            ps.setString(2, cliente.getNomeCompleto());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefone());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void update(Cliente cliente) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                    "UPDATE Cliente SET Nome = ?, Email = ?, Telefone = ? WHERE BI = ?"
            );

            ps.setString(1, cliente.getNomeCompleto());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getDocumento());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public Cliente findById(String bi) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                    "SELECT * FROM Cliente WHERE BI = ?"
            );

            ps.setString(1, bi);
            rs = ps.executeQuery();

            if (rs.next()) {
                return instantiateCliente(rs);
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
    public ArrayList<Cliente> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList<Cliente> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(
                    "SELECT * FROM Cliente ORDER BY Nome"
            );

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(instantiateCliente(rs));
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    private Cliente instantiateCliente(ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getInt("Id"),
                rs.getString("BI"),
                rs.getString("Nome"),
                rs.getString("Email"),
                rs.getString("Telefone")
        );
    }
}
