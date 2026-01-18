/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.impl;


import db.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.dao.ServicoAdicionalDao;
import model.entities.ServicoAdicional;
import model.enums.FormaCobranca;
import model.enums.TipoServico;
import model.exceptions.DbException;

/**
 *
 * @author jorge-victor
 */
public class ServicoAdicionalDaoJDBC implements ServicoAdicionalDao {

    private Connection conn;

    public ServicoAdicionalDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(ServicoAdicional s, int codigoReserva) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                    "INSERT INTO ServicoAdicional "
                    + "(Descricao, PrecoUnitario, Quantidade, TipoServico, FormaCobranca, ReservaId) "
                    + "VALUES (?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, s.getDescricao());
            ps.setDouble(2, s.getPrecoUnitario());
            ps.setInt(3, s.getQuantidade());
            ps.setString(4, s.getTipoServico().name());
            ps.setString(5, s.getFormaCobranca().name());
            ps.setInt(6, codigoReserva);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public List<ServicoAdicional> findByReserva(int codigoReserva) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ServicoAdicional> list = new ArrayList<>();

        try {
            ps = conn.prepareStatement(
                    "SELECT * FROM ServicoAdicional WHERE ReservaId = ? "
            );
            ps.setInt(1, codigoReserva);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(instantiateServico(rs));
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
    public double totalConsumo(int codigoReserva) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(
                    "SELECT SUM(PrecoUnitario * Quantidade) FROM ServicoAdicional WHERE ReservaId = ?"
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

    private ServicoAdicional instantiateServico(ResultSet rs) throws SQLException {
        return new ServicoAdicional(
                rs.getInt("Id"),
                rs.getDouble("PrecoUnitario"),
                rs.getInt("Quantidade"),
                TipoServico.valueOf(rs.getString("TipoServico")),
                FormaCobranca.valueOf(rs.getString("FormaCobranca"))
        );
    }

}
