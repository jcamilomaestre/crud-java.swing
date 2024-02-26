/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author javie
 */
public class EmpleadoModelo {
    
    // Propiedades de los empleados
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private int Documento;
    private String NDocumento;
    private String telefono;

    public EmpleadoModelo() {
    }

    @Override
    public String toString() {
        return "EmpleadoModelo{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", password=" + password + ", Documento=" + Documento + ", NDocumento=" + NDocumento + ", telefono=" + telefono + '}';
    }
    
    // Metodos getters y setters de los empleados
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDocumento() {
        return Documento;
    }

    public void setDocumento(int Documento) {
        this.Documento = Documento;
    }

    public String getNDocumento() {
        return NDocumento;
    }

    public void setNDocumento(String NDocumento) {
        this.NDocumento = NDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
