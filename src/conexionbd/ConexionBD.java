/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexionbd;

import Conexion.ConexionMySQL;
import Vistas.Formulario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author javie
 */
public class ConexionBD {
    
   // Iniciamos al aplicacion y llamamos a la vista Formulario
   public static void main(String args[]) {
       Conexion.ConexionMySQL con = new ConexionMySQL();
       System.out.println(con);
       Formulario form = new Formulario();
       form.show();
   }
    
}
