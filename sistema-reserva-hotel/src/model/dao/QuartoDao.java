/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.List;
import model.entities.Quarto;
import model.enums.Estado;

/**
 *
 * @author jorge-victor
 */
public interface QuartoDao {

    void insert(Quarto q);

    void updateEstado(int numero, Estado estado);

    Quarto findByNumero(int numero);

    List<Quarto> findDisponiveis();
}
