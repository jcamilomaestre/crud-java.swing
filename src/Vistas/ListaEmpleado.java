/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import controlador.EmpleadoControlador;
import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import modelo.EmpleadoModelo;

/**
 *
 * @author javie
 */
public class ListaEmpleado extends javax.swing.JPanel {

    /**
     * Creates new form PanelEmpleado
     */
    public ListaEmpleado() {
        initComponents();

        cargarEmpleados();
    }

    public void cargarEmpleados() {

        // Columnas de la tabla
        String[] columnNames = {"Id", "Nombres", "Apellidos", "Correo", "Contraseña", "Telefono", "Documento", "Tipo Documento"};

        // Modelo de la tabla
        DefaultTableModel model = new DefaultTableModel(null, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        EmpleadoControlador empleadoControlador = new EmpleadoControlador();

        // Llamamos al metodo listar de la clase controlador
        List<EmpleadoModelo> lista = empleadoControlador.listar();

        // Iteramos sobre la lista para poder añadir los valores al modelo
        for (EmpleadoModelo e : lista) {
            Object[] data = new Object[columnNames.length];

            data[0] = e.getId();
            data[1] = e.getNombre();
            data[2] = e.getApellido();
            data[3] = e.getCorreo();
            data[4] = e.getPassword();
            data[5] = e.getTelefono();
            data[6] = e.getNDocumento();
            if (e.getDocumento() == 1) {
                data[7] = "Tarjeta de Identidad";
            } else if (e.getDocumento() == 2) {
                data[7] = "Cédula";
            } else {
                data[7] = "Pasaporte";
            }

            model.addRow(data);
        }

        // Añadimos el modelo a la tabla
        jtEmpleados.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupOpciones = new javax.swing.JPopupMenu();
        jmEditar = new javax.swing.JMenuItem();
        jmEliminar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEmpleados = new javax.swing.JTable();

        jmEditar.setText("Editar");
        jmEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditarActionPerformed(evt);
            }
        });
        popupOpciones.add(jmEditar);

        jmEliminar.setText("Eliminar");
        jmEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEliminarActionPerformed(evt);
            }
        });
        popupOpciones.add(jmEliminar);

        setPreferredSize(new java.awt.Dimension(803, 642));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Lista de Empleados");

        jtEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtEmpleados.setComponentPopupMenu(popupOpciones);
        jScrollPane1.setViewportView(jtEmpleados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Para dar click derecho y "Editar"
    private void jmEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditarActionPerformed

        EmpleadoModelo empleado = new EmpleadoModelo();

        // Obtenemos la fila que seleccionamos
        int fila = jtEmpleados.getSelectedRow();

        if (fila != -1) {
            // Establecemos los valores del empleado seleccionado
            empleado.setId(Integer.parseInt(jtEmpleados.getValueAt(fila, 0).toString()));
            empleado.setNombre(jtEmpleados.getValueAt(fila, 1).toString());
            empleado.setApellido(jtEmpleados.getValueAt(fila, 2).toString());
            empleado.setCorreo(jtEmpleados.getValueAt(fila, 3).toString());
            empleado.setPassword(jtEmpleados.getValueAt(fila, 4).toString());
            empleado.setTelefono(jtEmpleados.getValueAt(fila, 5).toString());
            empleado.setNDocumento(jtEmpleados.getValueAt(fila, 6).toString());
            int identificacion;

            if (jtEmpleados.getValueAt(fila, 7).toString() == "Tarjeta de Identidad") {
                identificacion = 1;
            } else if (jtEmpleados.getValueAt(fila, 7).toString() == "Cédula") {
                identificacion = 2;
            } else {
                identificacion = 3;
            }
            empleado.setDocumento(identificacion);
        } else {
            JOptionPane.showMessageDialog(popupOpciones, "Debe seleccionar una fila");
        }

        // Abrimos el panel con el formulario y mandamos el empleado seleccionado
        EditarEmpleado EEPage = new EditarEmpleado(this);
        EEPage.setVisible(true);
        EEPage.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        EEPage.establecerDatosFormulario(empleado);
    }//GEN-LAST:event_jmEditarActionPerformed

    // Para dar click derecho y "Eliminar"
    private void jmEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEliminarActionPerformed
        // Obtenemos la fila que seleccionamos
       int fila = jtEmpleados.getSelectedRow();
        
        if (fila != -1) {
            int id = Integer.parseInt(jtEmpleados.getValueAt(fila, 0).toString());
            String nombre = jtEmpleados.getValueAt(fila, 1).toString();
            
            int respuesta = JOptionPane.showConfirmDialog(popupOpciones, "¿Seguro que desea eliminar a " + nombre + "?", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            
            if (respuesta == 0) {
                // Llamamos al metodo Eliminar de la clase EmpleadoControlador con el id del
                // empleado seleccionado
                EmpleadoControlador empleadoControlador = new EmpleadoControlador();
                boolean resultado = empleadoControlador.eliminar(id);
                
                if (resultado) {
                    JOptionPane.showMessageDialog(popupOpciones, "Empleado eliminado " + nombre);
                    cargarEmpleados();
                } else {
                    JOptionPane.showMessageDialog(popupOpciones, "Hubo un problema al eliminar al empleado");
                }
            }
        } else {
            JOptionPane.showMessageDialog(popupOpciones, "Debe seleccionar una fila");
        }
    }//GEN-LAST:event_jmEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmEditar;
    private javax.swing.JMenuItem jmEliminar;
    private javax.swing.JTable jtEmpleados;
    private javax.swing.JPopupMenu popupOpciones;
    // End of variables declaration//GEN-END:variables
}
