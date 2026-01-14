/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package duan1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class TestConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException{
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";       
        String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=PolyCafe;trustServerCertificate=true;"; 
        String userDb="sa";
        String passDb="123456";
        try {
            Class.forName(driver);
            Connection conn=DriverManager.getConnection(dbUrl,userDb,passDb);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
