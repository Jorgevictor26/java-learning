/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;
import model.entities.ServicoAdicional;

/**
 *
 * @author jorge-victor
 */
public interface ServicoAdicionalDao {

    public void insert(ServicoAdicional s, int codigoReserva);

    public List<ServicoAdicional> findByReserva(int codigoReserva);

    public double totalConsumo(int codigoReserva);
}
