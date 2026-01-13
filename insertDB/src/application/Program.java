/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import db.DB;
import db.DbException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();

            ps = conn.prepareStatement("insert into seller(Name, Email, Birthdate, BaseSalary, DepartmentId)"
                    + "VALUES"
                    + "(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, "Jorge");
            ps.setString(2, "jv@gmail.com");
            LocalDate data = LocalDate.parse("12-10-2003", fmt);
            ps.setDate(3, java.sql.Date.valueOf(data));
            ps.setDouble(4, 400.5000);
            ps.setInt(5, 2);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    System.out.println("Id criado: " + rs.getInt(1));
                }
            } else {
                System.out.println("No rows affected!");
            }
            rs = ps.executeQuery("select * "
                    + "from seller ");

            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("Id") + ", Nome: " + rs.getString("Name"));
            }

        } catch (DbException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeStatement(ps);
            DB.closeConnection();
        }
    }
}
