/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author javie
 */
public class ConexionMySQL {
    
    // Variables de las credenciales de la base de datos
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";
    public static final String URL = "jdbc:mysql://localhost:3306/foodies";
    private Connection connection;
    
    /**
     * @param args the command line arguments
     */

    public ConexionMySQL() {
        
        // Conectamos a la base de datos
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println("Conectado c:");
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
    }

    public Connection getConnection() {
        return connection;
    }
}
