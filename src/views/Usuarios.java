/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * IngresoCliente.java
 *
 * Created on 07-abr-2013, 11:16:29
 */
package views;

import conexion.Conexion;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class Usuarios extends javax.swing.JInternalFrame {

    DefaultTableModel model;

    /**
     * Creates new form IngresoCliente
     */
    public static Connection sql;
    public static Statement s;

    public Usuarios() {
        initComponents();
        bloquear();
        cargar("");

    }

    void bloquear() {

        txtnom.setEnabled(false);
        txtape.setEnabled(false);
        txtdir.setEnabled(false);
        txtpassword.setEnabled(false);
        txttel.setEnabled(false);
        txtemail.setEnabled(false);

        cborol.setEnabled(false);
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(true);
        btncancelar.setEnabled(true);
        btnactualizar.setEnabled(false);

    }

    void limpiar() {

        txtnom.setText("");
        txtdir.setText("");

        txtpassword.setText("");
        txtemail.setText("");
        txttel.setText("");
        txtape.setText("");

    }

    void desbloquear() {

        txtnom.setEnabled(true);
        txtape.setEnabled(true);
        txtdir.setEnabled(true);
        txtpassword.setEnabled(true);
        txttel.setEnabled(true);
        txtemail.setEnabled(true);
        cboestado.setEnabled(true);
        cborol.setEnabled(true);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(false);
        btncancelar.setEnabled(true);
        btnactualizar.setEnabled(false);
    }

    void cargar(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        String mostrar = "SELECT * FROM usuarios WHERE CONCAT(nombres,apellidos,telefono,direccion,email,rol,estado) LIKE '%" + valor + "%'";
        String[] Titulos = {"NOMBRES", "APELLIDOS", "DIRECCIÓN", "TELEFONO", "CORREO", "ROL", "ESTADO"};
        modelo.setColumnIdentifiers(Titulos);
        this.tbusuarios.setModel(modelo);
        Conexion j = new Conexion();
        j.conectar();
        sql = j.sql;
        try {
            String[] registros = new String[7];
            s = sql.createStatement();
            ResultSet rs = s.executeQuery(mostrar);
            while (rs.next()) {
                registros[0] = rs.getString("nombreS");
                registros[1] = rs.getString("apellidoS");
                registros[2] = rs.getString("direccion");
                registros[3] = rs.getString("telefono");
                registros[4] = rs.getString("email");
                registros[5] = rs.getString("rol");
                registros[6] = rs.getString("estado");
                modelo.addRow(registros);
            }
            tbusuarios.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnmodificar = new javax.swing.JMenuItem();
        mneliminar = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Label_ciCliente1 = new javax.swing.JLabel();
        Label_ciCliente2 = new javax.swing.JLabel();
        Label_ciCliente3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        cborol = new javax.swing.JComboBox();
        txtpassword = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Label_NombreCliente = new javax.swing.JLabel();
        txtnom = new javax.swing.JTextField();
        txtape = new javax.swing.JTextField();
        Label_ApellidoCliente = new javax.swing.JLabel();
        Label_DireccionCliente = new javax.swing.JLabel();
        txttel = new javax.swing.JTextField();
        Label_TelefonoCliente = new javax.swing.JLabel();
        txtdir = new javax.swing.JTextField();
        cboestado = new javax.swing.JComboBox();
        Label_TelefonoCliente1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbusuarios = new javax.swing.JTable();
        btnbuscar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        mnmodificar.setText("Modificar");
        mnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnmodificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnmodificar);

        mneliminar.setText("Eliminar");
        mneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mneliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mneliminar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("GESTIÓN DE USUARIOS");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnactualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btnguardar)
                    .addComponent(btnactualizar)
                    .addComponent(btncancelar)
                    .addComponent(btnsalir))
                .addGap(136, 136, 136))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label_ciCliente1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Label_ciCliente1.setForeground(new java.awt.Color(102, 102, 102));
        Label_ciCliente1.setText("Correo");
        Label_ciCliente1.setToolTipText("");
        jPanel4.add(Label_ciCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 88, -1));

        Label_ciCliente2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Label_ciCliente2.setForeground(new java.awt.Color(102, 102, 102));
        Label_ciCliente2.setText("Rol");
        Label_ciCliente2.setToolTipText("");
        jPanel4.add(Label_ciCliente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 88, -1));

        Label_ciCliente3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Label_ciCliente3.setForeground(new java.awt.Color(102, 102, 102));
        Label_ciCliente3.setText("Contraseña");
        Label_ciCliente3.setToolTipText("");
        jPanel4.add(Label_ciCliente3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 88, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(80, 80, 97));
        jLabel11.setText("Datos de acceso");
        jLabel11.setToolTipText("");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtemailKeyTyped(evt);
            }
        });
        jPanel4.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 250, -1));

        cborol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ADMINISTRADOR", "ENCARGADO" }));
        jPanel4.add(cborol, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 250, -1));
        jPanel4.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 250, -1));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(80, 80, 97));
        jLabel4.setText("Datos personales");
        jLabel4.setToolTipText("");

        Label_NombreCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Label_NombreCliente.setForeground(new java.awt.Color(102, 102, 102));
        Label_NombreCliente.setText("Nombre completo");
        Label_NombreCliente.setToolTipText("");

        txtnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnomKeyTyped(evt);
            }
        });

        txtape.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapeKeyTyped(evt);
            }
        });

        Label_ApellidoCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Label_ApellidoCliente.setForeground(new java.awt.Color(102, 102, 102));
        Label_ApellidoCliente.setText("Apellido");

        Label_DireccionCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Label_DireccionCliente.setForeground(new java.awt.Color(102, 102, 102));
        Label_DireccionCliente.setText("Dirección");
        Label_DireccionCliente.setToolTipText("");

        txttel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelKeyTyped(evt);
            }
        });

        Label_TelefonoCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Label_TelefonoCliente.setForeground(new java.awt.Color(102, 102, 102));
        Label_TelefonoCliente.setText("Teléfono");

        cboestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO" }));

        Label_TelefonoCliente1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Label_TelefonoCliente1.setForeground(new java.awt.Color(102, 102, 102));
        Label_TelefonoCliente1.setText("Estado");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Label_DireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Label_TelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Label_TelefonoCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(Label_ApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(Label_NombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_NombreCliente)
                    .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_ApellidoCliente)
                    .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_DireccionCliente)
                    .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_TelefonoCliente)
                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_TelefonoCliente1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbusuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbusuarios.setComponentPopupMenu(jPopupMenu1);
        tbusuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tbusuariosKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(tbusuarios);

        btnbuscar.setText("Mostrar Todos");

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        jLabel10.setText("BUSCAR:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbuscar))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
// TODO add your handling code here:
    try {
        Conexion j = new Conexion();
        j.conectar();
        j.editar("UPDATE usuarios SET nombres='" + txtnom.getText().toUpperCase()
                + "',apellidos='" + txtape.getText().toUpperCase()
                + "',telefono='" + txttel.getText()
                + "',direccion='" + txtdir.getText().toUpperCase()
                + "',email='" + txtemail.getText().toLowerCase()
                + "',rol='" + cborol.getSelectedItem().toString().toUpperCase()
                + "',estado='" + cboestado.getSelectedItem().toString().toUpperCase()
                + "',password='" + txtpassword.getText()
                + "' WHERE email='" + txtemail.getText() + "'");

        cargar("");
        bloquear();
    } catch (Exception e) {
        System.out.print(e.getMessage());
    }

}//GEN-LAST:event_btnactualizarActionPerformed

private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
// TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_btnsalirActionPerformed

private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
// TODO add your handling code here:
    desbloquear();
    limpiar();
    txtnom.requestFocus();
}//GEN-LAST:event_btnnuevoActionPerformed

private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
// TODO add your handling code here:
    bloquear();
}//GEN-LAST:event_btncancelarActionPerformed

private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
// TODO add your handling code here:
    String estado, dir, nom, ape, tel, rol,  pass, email;

    estado = cboestado.getSelectedItem().toString();
    nom = txtnom.getText().toUpperCase();
    ape = txtape.getText().toUpperCase();
    dir = txtdir.getText().toUpperCase();
    tel = txttel.getText();
    rol = cborol.getSelectedItem().toString();
    email = txtemail.getText().toUpperCase();
    pass = txtpassword.getText().toUpperCase();
   

    try {
        Conexion j = new Conexion();
        j.conectar();
        String sql = "INSERT INTO usuarios(nombres,apellidos,telefono,direccion,email,password,rol,estado) VALUES('"
                + nom + "','"
                + ape + "','"
                + tel + "','"
                + dir + "','"
                + email + "','"
                + pass + "','"
                + rol + "','"
                + estado + "')";
        j.insertar(sql);
        System.out.println("EXITO");
        JOptionPane.showMessageDialog(null, "Guardado exitosamente");
        limpiar();
        cargar("");
        bloquear();
    } catch (Exception e) {
        System.out.println("ERROR");
    }
}//GEN-LAST:event_btnguardarActionPerformed

private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
// TODO add your handling code here:

}//GEN-LAST:event_txtbuscarActionPerformed

private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
// TODO add your handling code here:
    cargar(txtbuscar.getText());
}//GEN-LAST:event_txtbuscarKeyReleased

private void txttelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelKeyTyped
// TODO add your handling code here:
    char car = evt.getKeyChar();
    if (txttel.getText().length() > 10) {
        evt.consume();
    }
    if ((car < '0' || car > '9')) {
        evt.consume();
    }
}//GEN-LAST:event_txttelKeyTyped

private void txtemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyTyped
    char car = evt.getKeyChar();
    if (txtemail.getText().length() > 180) {
        evt.consume();
    }

}//GEN-LAST:event_txtemailKeyTyped

private void txtnomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyTyped
// TODO add your handling code here:
    char car = evt.getKeyChar();
    if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_SPACE)) {
        evt.consume();
    }
}//GEN-LAST:event_txtnomKeyTyped

private void txtapeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapeKeyTyped
// TODO add your handling code here:
    char car = evt.getKeyChar();
    if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z') && (car != (char) KeyEvent.VK_SPACE)) {
        evt.consume();
    }
}//GEN-LAST:event_txtapeKeyTyped

private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneliminarActionPerformed
// TODO add your handling code here:
    int fila = tbusuarios.getSelectedRow();
    String email = "";
    email = tbusuarios.getValueAt(fila, 4).toString();
    if (fila >= 0) {
        try {
            Conexion j = new Conexion();
            j.conectar();
            String sql = "DELETE FROM usuarios WHERE email='" + email + "'";
            j.eliminar(sql);

            cargar("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    } else {
        JOptionPane.showMessageDialog(this, "No ha selecionada ninguna fila");
    }

}//GEN-LAST:event_mneliminarActionPerformed

private void mnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnmodificarActionPerformed
// "CÓDIGO", "CÉDULA", "NOMBRES", "APELLIDOS", "DIRECCIÓN", "TELEFONO", "PLACA", "MODELO", "COLOR"    
    desbloquear();
    btnactualizar.setEnabled(true);
    btnguardar.setEnabled(false);
    int filamodificar = tbusuarios.getSelectedRow();
    if (filamodificar >= 0) {
        txtnom.setText(tbusuarios.getValueAt(filamodificar, 0).toString());
        txtape.setText(tbusuarios.getValueAt(filamodificar, 1).toString());
        txtdir.setText(tbusuarios.getValueAt(filamodificar, 2).toString());
        txttel.setText(tbusuarios.getValueAt(filamodificar, 3).toString());
        txtemail.setText(tbusuarios.getValueAt(filamodificar, 4).toString());
        cborol.setSelectedItem(tbusuarios.getValueAt(filamodificar, 5).toString());
        cboestado.setSelectedItem(tbusuarios.getValueAt(filamodificar, 6).toString());
        this.txtemail.setEnabled(false);

    } else {
        JOptionPane.showMessageDialog(this, "No ha seleccionado ");
    }
}//GEN-LAST:event_mnmodificarActionPerformed

    private void tbusuariosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbusuariosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tbusuariosKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_ApellidoCliente;
    private javax.swing.JLabel Label_DireccionCliente;
    private javax.swing.JLabel Label_NombreCliente;
    private javax.swing.JLabel Label_TelefonoCliente;
    private javax.swing.JLabel Label_TelefonoCliente1;
    private javax.swing.JLabel Label_ciCliente1;
    private javax.swing.JLabel Label_ciCliente2;
    private javax.swing.JLabel Label_ciCliente3;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cboestado;
    private javax.swing.JComboBox cborol;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JMenuItem mnmodificar;
    private javax.swing.JTable tbusuarios;
    private javax.swing.JTextField txtape;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtdir;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables

}
