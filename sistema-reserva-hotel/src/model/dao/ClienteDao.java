/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.ArrayList;
import model.entities.Cliente;

/**
 *
 * @author jorge-victor
 */
public interface ClienteDao {

    void insert(Cliente cliente);

    void update(Cliente cliente);

    Cliente findById(String BI);

    ArrayList<Cliente> findAll();
}
