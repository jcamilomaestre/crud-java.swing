/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.EmpleadoDao;
import java.util.List;
import modelo.EmpleadoModelo;

/**
 *
 * @author javie
 */
public class EmpleadoControlador {
    
    private EmpleadoDao empleadoDao;
    
    public EmpleadoControlador() {
        this.empleadoDao = new EmpleadoDao();
    }
    
    // Llamamos al metodo registrar de la clase EmpleadoDao
    public boolean registrar(EmpleadoModelo empleado) {
        boolean respuesta = this.empleadoDao.registrar(empleado);
        
        return respuesta;
    }
    
    // Llamamos al metodo listar de la clase EmpleadoDao
    public List<EmpleadoModelo> listar() {
        List<EmpleadoModelo> lista = this.empleadoDao.listar();
        
        return lista;
    }
    
    // Llamamos al metodo editar de la clase EmpleadoDao
    public boolean editar(EmpleadoModelo empleado) {
        boolean respuesta = this.empleadoDao.editar(empleado);
        
        return respuesta;
    }
    
    // Llamamos al metodo eliminar de la clase EmpleadoDao
    public boolean eliminar(int id) {
        boolean respuesta = this.empleadoDao.eliminar(id);
        
        return respuesta;
    }
}
