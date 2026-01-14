/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.ArrayList;
import model.entities.Account;

/**
 *
 * @author jorge-victor
 */
public interface AccountDao {

    void insert(Account account);

    void update(Account account);

    void delete(Integer id);

    Account findById(Integer id);

    ArrayList<Account> findAll();

}
