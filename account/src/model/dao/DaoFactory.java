/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.dao.impl.AccountDaoJDBC;

/**
 *
 * @author jorge-victor
 */
public class DaoFactory {

    public static AccountDao createAccountDao() {
        return new AccountDaoJDBC();
    }
}
