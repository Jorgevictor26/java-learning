/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import db.DB;
import db.DbException;
import java.sql.SQLException;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from department where id>=3");

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + " " + rs.getString("Name"));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeConnection();
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}
