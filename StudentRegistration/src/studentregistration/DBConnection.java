/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentregistration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // <- load driver
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb", "root", ""
            );
            System.out.println("✅ Database connected successfully!");
        } catch (Exception e){
            System.out.println("❌ Connection error: " + e.getMessage());
        }
        return conn;
    }
}


