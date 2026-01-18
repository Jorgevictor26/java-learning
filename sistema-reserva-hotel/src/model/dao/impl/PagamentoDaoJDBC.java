/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.impl;

import model.dao.PagamentoDao;
import db.DB;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.entities.Payment;
import model.enums.EstadoPagamento;
import model.enums.Metodo;
import model.exceptions.DbException;

/**
 *
 * @author jorge-victor
 */
public class PagamentoDaoJDBC implements PagamentoDao {

    private Connection conn;

    public PagamentoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Payment p, int codigoReserva) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                    "INSERT INTO Pagamento "
                    + "(ValorPago, DataPagamento, Metodo, EstadoPagamento, ReservaId) "
                    + "VALUES (?, ?, ?, ?, ?)"
            );

            ps.setDouble(1, p.getValorPago());
            ps.setTimestamp(2, Timestamp.valueOf(p.getDataPagamento()));
            ps.setString(3, p.getMetodo().name());
            ps.setString(4, p.getEstadoPagamento().name());
            ps.setInt(5, codigoReserva);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public List<Payment> findByReserva(int codigoReserva) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Payment> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(
                    "SELECT * FROM Pagamento WHERE ReservaId = ? ORDER BY DataPagamento"
            );
            ps.setInt(1, codigoReserva);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(instantiatePayment(rs));
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    @Override
    public double totalPago(int codigoReserva) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                    "SELECT SUM(ValorPago) FROM Pagamento WHERE ReservaId = ?"
            );
            ps.setInt(1, codigoReserva);

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
            return 0.0;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    private Payment instantiatePayment(ResultSet rs) throws SQLException {
        return new Payment(
                rs.getInt("Id"),
                rs.getDouble("ValorPago"),
                rs.getTimestamp("DataPagamento").toLocalDateTime(),
                Metodo.valueOf(rs.getString("Metodo")),
                EstadoPagamento.valueOf(rs.getString("EstadoPagamento"))
        );
    }
}
