/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.impl;

import db.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.dao.QuartoDao;
import model.entities.Quarto;
import model.enums.Estado;
import model.enums.Tipo;
import model.exceptions.DbException;

/**
 *
 * @author jorge-victor
 */
public class QuartoDaoJDBC implements QuartoDao {

    private Connection conn;

    public QuartoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Quarto q) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                    "INSERT INTO Quarto (PrecoDiario, Tipo, Capacidade, Estado) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            ps.setDouble(1, q.getPrecoDiarioBase());
            ps.setString(2, q.getTipo().name());
            ps.setInt(3, q.getCapacidade());
            ps.setString(4, q.getEstado().name());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                q.setNumero(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public void updateEstado(int numero, Estado estado) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                    "UPDATE Quarto SET Estado = ? WHERE Numero = ?"
            );

            ps.setString(1, estado.name());
            ps.setInt(2, numero);

            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new DbException("Quarto nao encontrado");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public Quarto findByNumero(int numero) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                    "SELECT * FROM Quarto WHERE Numero = ?"
            );
            ps.setInt(1, numero);

            rs = ps.executeQuery();
            if (rs.next()) {
                return instantiateQuarto(rs);
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
    public List<Quarto> findDisponiveis() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Quarto> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(
                    "SELECT * FROM Quarto WHERE Estado = ? ORDER BY Numero"
            );
            ps.setString(1, Estado.ATIVO.name());

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(instantiateQuarto(rs));
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    private Quarto instantiateQuarto(ResultSet rs) throws SQLException {
        return new Quarto(
                rs.getInt("Numero"),
                rs.getDouble("PrecoDiario"),
                Tipo.valueOf(rs.getString("Tipo")),
                rs.getInt("Capacidade"),
                Estado.valueOf(rs.getString("Estado"))
        );
    }

}
