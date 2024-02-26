/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conexion.ConexionMySQL;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpleadoModelo;

/**
 *
 * @author javie
 */
public class EmpleadoDao {
    
    private Conexion.ConexionMySQL fabricaConexion;

    // Instanciamos un objeto de la clase ConexionMySQL desde el constructor EmpleadoDao
    public EmpleadoDao() {
        this.fabricaConexion = new ConexionMySQL();
    }
    
    // Operaciones para realizar la sentencia de INSERT en la base de datos
    public boolean registrar(EmpleadoModelo empleado) {
        
        try {
            
            // Sentencia SQL
            String SQL = "INSERT INTO empleado(nombre, apellido, correo, contraseña, telefono, identificacion, tipo_documento_id)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)";
            
            // Conexión a la base de datos
            Connection connection = this.fabricaConexion.getConnection();
            
            // Preparamos la sentencia
            PreparedStatement sentencia = connection.prepareStatement(SQL);
            
            // Establecemos los valores de la sentencia SQL
            sentencia.setString(1, empleado.getNombre());
            sentencia.setString(2, empleado.getApellido());
            sentencia.setString(3, empleado.getCorreo());
            sentencia.setString(4, empleado.getPassword());
            sentencia.setString(5, empleado.getTelefono());
            sentencia.setString(6, empleado.getNDocumento());
            sentencia.setInt(7, empleado.getDocumento());
            
            // Ejecutamos y cerramos
            sentencia.executeUpdate();
            sentencia.close();
            connection.close();
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Error en Clase EmpleadoDao.java");
            System.out.println(e.getMessage());
            return false;
        }
    }
    
        
    // Operaciones para realizar la sentencia de SELECT en la base de datos
    public List<EmpleadoModelo> listar() {
        
        // Para almacenar los empleados de la base de datos
        List<EmpleadoModelo> lista = new ArrayList<>();
        
        try {
            
            // Sentencia SQL
            String SQL = "SELECT * FROM empleado";
            
            // Conexión a la base de datos
            Connection connection = this.fabricaConexion.getConnection();
            
            // Preparamos la sentencia
            PreparedStatement sentencia = connection.prepareStatement(SQL);
            
            // Guardamos el resultado de la ejecucion de la sentencia
            ResultSet resultado = sentencia.executeQuery();
            
            // El bucle seguira hasta la ultima fila
            while (resultado.next()) {
                EmpleadoModelo empleado = new EmpleadoModelo();
                
                // Creamos un empleado y establecemos las propiedades
                empleado.setId(resultado.getInt(1));
                empleado.setNombre(resultado.getString(2));
                empleado.setApellido(resultado.getString(3));
                empleado.setCorreo(resultado.getString(4));
                empleado.setPassword(resultado.getString(5));
                empleado.setTelefono(resultado.getString(6));
                empleado.setNDocumento(resultado.getString(7));
                empleado.setDocumento(resultado.getInt(8));
                
                // Guardamos al empleado en la lista
                lista.add(empleado);
            }
            
            // Cerramos conexiones
            resultado.close();
            sentencia.close();
            connection.close();
            
        } catch (Exception e) {
            System.out.println("Error en Clase EmpleadoDao.java");
            System.out.println(e.getMessage());
        }
        
        return lista;
    }
    
    // Operaciones para realizar la sentencia de UPDATE en la base de datos
    public boolean editar(EmpleadoModelo empleado) {
        
        try {
            
            // Sentencia SQL
            String SQL = "UPDATE empleado set nombre=?, apellido=?, correo=?, contraseña=?, telefono=?, identificacion=?, tipo_documento_id=? WHERE id_empleado=?";
            
            // Creamos la conexion
            Connection connection = this.fabricaConexion.getConnection();
            
            // Preparamos sentencia
            PreparedStatement sentencia = connection.prepareStatement(SQL);
            
            // Establecemos los valores de la sentencia
            sentencia.setString(1, empleado.getNombre());
            sentencia.setString(2, empleado.getApellido());
            sentencia.setString(3, empleado.getCorreo());
            sentencia.setString(4, empleado.getPassword());
            sentencia.setString(5, empleado.getTelefono());
            sentencia.setString(6, empleado.getNDocumento());
            sentencia.setInt(7, empleado.getDocumento());
            
            sentencia.setInt(8, empleado.getId());
            
            // Ejecutamos y cerramos
            sentencia.executeUpdate();
            sentencia.close();
            connection.close();
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Error en Clase EmpleadoDao.java");
            System.out.println(e.getMessage());
            
            return false;
        }
    }
    
    // Operaciones para realizar la sentencia de DELETE en la base de datos
    public boolean eliminar(int id) {
        try {
            // Sentencia SQL
            String SQL = "DELETE FROM empleado WHERE id_empleado=?";
            
            // Creamos la conexion
            Connection connection = this.fabricaConexion.getConnection();
            
            // Preparamos sentencia
            PreparedStatement sentencia = connection.prepareStatement(SQL);
            
            // Ejecutamos y cerramos
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
            sentencia.close();
            connection.close();
            
            return true;
            
        } catch (Exception e) {
            System.out.println("Error en Clase EmpleadoDao.java");
            System.out.println(e.getMessage());
            
            return false;
        }
    }
}
