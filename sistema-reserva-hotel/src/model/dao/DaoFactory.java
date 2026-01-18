/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import db.DB;
import model.dao.impl.ClienteDaoJDBC;
import model.dao.impl.PagamentoDaoJDBC;
import model.dao.impl.QuartoDaoJDBC;
import model.dao.impl.ReservaDaoJDBC;
import model.dao.impl.ServicoAdicionalDaoJDBC;

/**
 *
 * @author jorge-victor
 */
public class DaoFactory {

    public static ClienteDao createClienteDao() {
        return new ClienteDaoJDBC(DB.getConnection());
    }
    
    public static QuartoDao createQuartoDAO() {
        return new QuartoDaoJDBC(DB.getConnection());
    }

    public static ReservaDao createReservaDAO() {
        return new ReservaDaoJDBC(DB.getConnection());
    }

    public static PagamentoDao createPagamentoDAO() {
        return new PagamentoDaoJDBC(DB.getConnection());
    }

    public static ServicoAdicionalDao createServicoAdicionalDAO() {
        return new ServicoAdicionalDaoJDBC(DB.getConnection());
    }
}
