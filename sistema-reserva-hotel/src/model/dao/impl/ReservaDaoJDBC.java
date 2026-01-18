/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.impl;

import db.DB;
import java.sql.Timestamp;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.dao.ReservaDao;
import model.entities.Cliente;
import model.entities.Quarto;
import model.entities.Reserva;
import model.enums.EstadoReserva;
import model.exceptions.DbException;

/**
 *
 * @author jorge-victor
 */
public class ReservaDaoJDBC implements ReservaDao {

    private Connection conn;

    public ReservaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Reserva r) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                    "INSERT INTO Reserva "
                    + "(QtidadeHospedes, EstadoReserva, DataCheckIn, DataCheckOut, DataCriacao, ClienteId, QuartoId) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );

            ps.setInt(1, r.getQtidadeHospedes());
            ps.setString(2, r.getEstadoReserva().name());
            ps.setDate(3, java.sql.Date.valueOf(r.getDataCheckIn()));
            ps.setDate(4, java.sql.Date.valueOf(r.getDataCheckOut()));
            ps.setTimestamp(5, Timestamp.valueOf(r.getDataCriacao()));
            ps.setInt(6, r.getCliente().getId());
            ps.setInt(7, r.getQuarto().getNumero());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                r.setCodigoReserva(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public Reserva findByCodigo(int codigo) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                    "SELECT * FROM Reserva WHERE CodigoReserva = ?"
            );
            ps.setInt(1, codigo);
            rs = ps.executeQuery();

            if (rs.next()) {
                return instantiateReserva(rs);
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
    public List<Reserva> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Reserva> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement("SELECT * FROM Reserva ORDER BY DataCheckIn");
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(instantiateReserva(rs));
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
    public void updateDatas(int codigo, LocalDate dataCheckin, LocalDate dataCheckout) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                    "UPDATE Reserva SET DataCheckIn = ?, DataCheckOut = ? WHERE CodigoReserva = ?"
            );
            ps.setDate(1, java.sql.Date.valueOf(dataCheckin));  
            ps.setDate(2, java.sql.Date.valueOf(dataCheckout));  

            ps.setInt(3, codigo);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void updateEstado(int codigo, EstadoReserva estado) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(
                    "UPDATE Reserva SET EstadoReserva = ? WHERE CodigoReserva = ?"
            );
            ps.setString(1, estado.name());
            ps.setInt(2, codigo);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }
    
    private Reserva instantiateReserva(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("ClienteId"));

        Quarto quarto = new Quarto();
        quarto.setNumero(rs.getInt("QuartoId"));

        return new Reserva(
                rs.getInt("CodigoReserva"),
                rs.getInt("QtidadeHospedes"),
                rs.getDate("DataCheckIn").toLocalDate(),
                rs.getDate("DataCheckOut").toLocalDate(),
                cliente, quarto
        );
    }
}
